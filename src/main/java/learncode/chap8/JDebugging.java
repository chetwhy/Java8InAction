package learncode.chap8;

import lambdasinaction.chap8.Peek;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/5 23:18
 * @Version 1.0
 */
public class JDebugging {
    public static void main(String[] args) {
        /*List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(Point::getX).forEach(System.out::println);*/

        /*List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream().map(JDebugging::deivideByZero).forEach(System.out::println);*/

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .peek(x-> System.out.println("from stream: "+x))
                .map(a -> a + 17)
                .peek(x-> System.out.println("after map: "+x))
                .filter(a -> a % 2 == 0)
                .peek(x-> System.out.println("from filter: "+x))
                .limit(3)
                .peek(x-> System.out.println("after limit: "+x))
                .collect(Collectors.toList());
                //.forEach(System.out::println);

    }

    public static int deivideByZero(int n) {
        return n / 0;
    }
}
