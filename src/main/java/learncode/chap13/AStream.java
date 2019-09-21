package learncode.chap13;

import learncode.commons.Apple;

import java.util.Comparator;
import java.util.stream.LongStream;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/21 16:24
 * @Version 1.0
 */
public class AStream {

    public static int factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    public static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
    }

    public static long factorialTailRecursive(long n) {
        return facotrialHelper(1, n);
    }

    public static long facotrialHelper(long acc, long n) {
        return n == 1 ? acc : facotrialHelper(acc * n, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorialIterative(10));
        System.out.println(factorialRecursive(10));
        System.out.println(factorialStreams(10));
        System.out.println(factorialTailRecursive(10));

        Comparator<Apple> comparing = Comparator.comparing(Apple::getColor);
    }
}
