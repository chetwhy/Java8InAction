package learncode.chap8;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:07
 * @Version 1.0
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
