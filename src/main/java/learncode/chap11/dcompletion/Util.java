package learncode.chap11.dcompletion;

import java.util.Random;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/15 16:14
 * @Version 1.0
 */
public class Util {
    public static final Random RANDOM = new Random();

    public static void randomDelay() {
        int delay = 500 + RANDOM.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
