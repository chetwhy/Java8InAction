package learncode.chap11;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/11 23:04
 * @Version 1.0
 */
public class AFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return null;
            }
        });
        // doSomethingElse()
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
