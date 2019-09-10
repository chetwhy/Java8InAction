package learncode.chap8;

import org.openjdk.jmh.annotations.TearDown;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:32
 * @Version 1.0
 */
public class NYTimes implements Obersver {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! "+tweet);
        }
    }
}
