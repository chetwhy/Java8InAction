package learncode.chap11.bdiscount;

import learncode.chap11.ashop.Shop;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/14 2:31
 * @Version 1.0
 */
public class Discount {
    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    public enum Code {
        NONE(0),SILVER(5),GOLD(10),PLATIUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        delay();
        return format(price*(100 - code.percentage) / 100);
    }

    private static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    private static double format(double number) {
        synchronized (formatter) {
            return Double.parseDouble(formatter.format(number));
        }
    }

    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getPriceEnum(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceEnum(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());

        return priceFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });
}
