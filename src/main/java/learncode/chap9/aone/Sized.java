package learncode.chap9.aone;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/9 0:07
 * @Version 1.0
 */
public interface Sized {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
