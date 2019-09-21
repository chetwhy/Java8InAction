package learncode.chap12;

import java.time.Instant;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/15 23:07
 * @Version 1.0
 */
public class CTestInstant {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(3);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant3 = Instant.ofEpochSecond(4, -1_000_000_000);
    }
}
