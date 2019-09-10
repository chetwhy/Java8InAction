package learncode.chap10;

import java.util.Optional;

import learncode.chap10.common.Car;
import learncode.chap10.common.Insurance;
import learncode.chap10.common.Person;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/10 22:52
 * @Version 1.0
 */
public class AOptional {
    public static void main(String[] args) {
        Optional<Car> optCar = Optional.empty();

        Car car = new Car();
        Optional<Car> optCar2 = Optional.of(car);

        Optional<Car> optCar3 = Optional.ofNullable(car);

        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        Optional<Insurance> insurance1 = optCar3.map(a -> findCheapestInsurance());

        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        String name2 =
            optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");

        Insurance insurance2 = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance2);
        optionalInsurance.filter(a -> "aaa".equals(a.getName())).ifPresent(x -> System.out.println("ok"));
    }

    public static Insurance findCheapestInsurance() {
        return null;
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        return null;
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
