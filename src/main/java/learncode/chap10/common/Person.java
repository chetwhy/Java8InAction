package learncode.chap10.common;

import java.util.Optional;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/10 22:51
 * @Version 1.0
 */
public class Person {
    private Optional<Car> car;

    private int age;

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return car;
    }
}
