package learncode.chap11.ashop;

import learncode.chap11.bdiscount.Discount;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/12 0:07
 * @Version 1.0
 */
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPriceEnum(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];// 返回枚举数组中的某一个
        return String.format("%s:%.3f:%s", name, price, code);
    }

    public String getName() {
        return name;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncWithException(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncWithFactory(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
}
