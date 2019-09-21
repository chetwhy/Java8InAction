package learncode.chap12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/17 0:53
 * @Version 1.0
 */
public class DDurationPeriod {

    public static void main(String[] args) {
        Period days = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
        Duration seconds = Duration.between(LocalDateTime.of(2014, 3, 8, 9, 0, 0), LocalDateTime.of(2014, 3, 8, 9, 0, 3));
    }
}
