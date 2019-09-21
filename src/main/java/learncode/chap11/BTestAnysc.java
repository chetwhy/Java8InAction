package learncode.chap11;

import learncode.chap11.ashop.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/13 16:56
 * @Version 1.0
 */
public class BTestAnysc {

    private static final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    public static List<String> findPrices(String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public static List<String> findPricesParal(String product) {
        return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public static List<String> findPricesCompFut(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))).collect(Collectors.toList());
        return priceFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static List<String> findPricesDaemon(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)),executor)).collect(Collectors.toList());
        return priceFuture.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    private static final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findPricesDaemon("myPhone27s"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");


    }

}
