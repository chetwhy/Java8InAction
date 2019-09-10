package learncode.chap7;

import lambdasinaction.chap7.ParallelStreams;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/8/27 23:55
 * @Version 1.0
 */
public class AParallel {

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i->i+1).limit(n).reduce(0L,Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long rangeSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L,Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            Long sum = adder.apply(n);
            long duration = (System.nanoTime()-start) / 1_000_000;
            //System.out.println("Result: "+sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).forEach(accumulator::add);
        System.out.println(accumulator.total);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,n).parallel().forEach(accumulator::add);
        System.out.println(accumulator.total);
        return accumulator.total;
    }

    static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    public static void main(String[] args) {
        /*System.out.println(sequentialSum(10));
        System.out.println(parallelSum(10));

        System.out.println("Sequential sum done in:"+measureSumPerf(AParallel::sequentialSum, 10_000_000)+"msecs");
        System.out.println("Iterative sum done in:"+measureSumPerf(AParallel::iterativeSum, 10_000_000)+"msecs");
        System.out.println("Parallel sum done in:"+measureSumPerf(AParallel::parallelSum, 10_000_000)+"msecs");
        System.out.println("Range sum done in:"+measureSumPerf(AParallel::rangeSum, 10_000_000)+"msecs");
        System.out.println("ParallelRange sum done in:"+measureSumPerf(AParallel::parallelRangedSum, 10_000_000)+"msecs");*/

        System.out.println("SideEffect sequential sum done in: "+measureSumPerf(AParallel::sideEffectSum, 10_000_000L)+"msecs");
        System.out.println("SideEffect sequential sum done in: "+measureSumPerf(AParallel::sideEffectSum, 10_000_000L)+"msecs");
        System.out.println("SideEffect parallel sum done in: "+measureSumPerf(AParallel::sideEffectParallelSum, 10_000_000L)+"msecs");
        System.out.println("SideEffect parallel sum done in: "+measureSumPerf(AParallel::sideEffectParallelSum, 10_000_000L)+"msecs");
    }
}
