package learncode.chap8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/5 23:06
 * @Version 1.0
 */
public class IHigerFuntion {
    public void testFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = numbers.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        System.out.println(even);

    }
}
