package learncode.chap8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/2 23:24
 * @Version 1.0
 */
public class ProductFactory {
    final static Map<String, Supplier<Producdt>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Producdt createProduct(String name) {
        Supplier<Producdt> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new IllegalArgumentException("No such product: " + name);
    }

    public static void main(String[] args) {
        Producdt load = createProduce("loan");
        System.out.println(load);

    }

    public static Producdt createProduce(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product: " + name);
        }
    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream().map(p -> new Point(p.getX() + x, p.getY())).collect(Collectors.toList());
    }

    static private interface Producdt {}

    static private class Loan implements Producdt {}

    static private class Stock implements Producdt {}

    static private class Bond implements Producdt {}

}
