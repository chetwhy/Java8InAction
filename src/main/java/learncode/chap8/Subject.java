package learncode.chap8;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:36
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Obersver o);

    void notifyObservers(String tweet);
}
