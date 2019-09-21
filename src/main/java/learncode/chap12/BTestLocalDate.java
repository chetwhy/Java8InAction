package learncode.chap12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/15 22:49
 * @Version 1.0
 */
public class BTestLocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 8, 8);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();

        int year2 = date.get(ChronoField.YEAR);
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
        int day2 = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time0 = LocalTime.of(9, 30);
        LocalTime time = LocalTime.of(9, 30,20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        int hour2 = time.get(ChronoField.HOUR_OF_DAY);

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }
}
