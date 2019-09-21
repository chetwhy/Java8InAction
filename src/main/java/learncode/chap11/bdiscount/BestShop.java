package learncode.chap11.bdiscount;

import java.util.List;
import java.util.function.Supplier;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/14 14:20
 * @Version 1.0
 */
public class BestShop {
    private static Discount discount = new Discount();

    public static void main(String[] args) {
        execute("sequential",()->discount.findPricesSequential("Iphone27s"));
        execute("sequential",()->discount.findPricesFuture("Iphone27s"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
