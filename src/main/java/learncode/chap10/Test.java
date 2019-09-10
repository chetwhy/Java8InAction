package learncode.chap10;

import lambdasinaction.chap5.PuttingIntoPractice;
import org.junit.Assert;

import java.util.Optional;
import java.util.Properties;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/11 0:11
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-2");

        Assert.assertEquals(5,readDuration(props,"a"));
    }

    public static int readDurationWithOpt(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i->i>0).orElse(0);
    }

    public static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {

            }
        }
        return 0;
    }
}
