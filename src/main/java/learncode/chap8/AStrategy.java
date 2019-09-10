package learncode.chap8;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/1 22:05
 * @Version 1.0
 */
public class AStrategy {

    public static void main(String[] args) {
        Validator validator = new Validator(new IsNumberic());
        System.out.println(validator.validate("1111"));

        Validator validator1 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(validator1.validate("aaaa"));
    }
}
