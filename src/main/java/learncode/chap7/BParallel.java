package learncode.chap7;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/8/28 23:26
 * @Version 1.0
 */
public class BParallel {

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {

    }
}
