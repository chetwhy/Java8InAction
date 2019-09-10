package learncode.chap10;

import java.util.Optional;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/11 0:01
 * @Version 1.0
 */
public class OptionalUtility {

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("aa").orElse(0));
    }
}
