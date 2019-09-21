package learncode.chap11.dcompletion;

import lambdasinaction.chap11.Shop;
import learncode.chap11.bdiscount.Discount;
import learncode.chap11.bdiscount.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/15 16:24
 * @Version 1.0
 */
public class FindBestPrice {
    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product), executor
                ))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)
                ));
    }

    public void printPricesStream() {
        Stream<CompletableFuture<Void>> myPhone = findPricesStream("myPhone").map(f -> f.thenAccept(System.out::println));
        CompletableFuture[] futures = myPhone.toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
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
