package learncode.chap11.ashop;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/12 0:21
 * @Version 1.0
 */
public class ShopMain {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        // doSomethingElse()

        // at the same time
        try {
            Double price = futurePrice.get();
            System.out.printf("Price is %.2f%n",price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
