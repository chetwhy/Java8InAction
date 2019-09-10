package learncode.chap7;

import java.util.concurrent.RecursiveTask;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/8/28 23:09
 * @Version 1.0
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    public static final long THRESHOLD = 10_000;
    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    private long computeSequentiallly() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    @Override
    protected Long compute() {
        int length = end -start;
        if (length <= THRESHOLD) {
            return computeSequentiallly();
        }
        ForkJoinSumCalculator leftTasK = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTasK.fork();
        ForkJoinSumCalculator rightTasK = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTasK.compute();
        Long leftResult = leftTasK.join();
        return rightResult + leftResult;
    }
}
