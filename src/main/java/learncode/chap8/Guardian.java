package learncode.chap8;

import org.junit.Test;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:33
 * @Version 1.0
 */
public class Guardian implements Obersver {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
