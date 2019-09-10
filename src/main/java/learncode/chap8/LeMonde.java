package learncode.chap8;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:35
 * @Version 1.0
 */
public class LeMonde implements Obersver {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
