package learncode.chap8;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:32
 * @Version 1.0
 */
public class COberver {

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.registerObserver((String tweet)->{
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

    }
}
