package learncode.chap8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:37
 * @Version 1.0
 */
public class Feed implements Subject {
    private final List<Obersver> obersvers = new ArrayList<>();

    @Override
    public void registerObserver(Obersver o) {
        this.obersvers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        obersvers.forEach(o->o.notify(tweet));
    }
}
