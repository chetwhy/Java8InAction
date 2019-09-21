package learncode.chap12;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Description TODO
 * @Author YC
 * @Date 2019/9/17 1:00
 * @Version 1.0
 */
public class ETestFormat {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2018, 8, 8);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date1.withDayOfMonth(10);
        LocalDate date4 = date1.with(ChronoField.MONTH_OF_YEAR, 9);

        LocalDate date5 = date1.plusWeeks(1);
        LocalDate date6 = date1.plusDays(7);
        LocalDate date7 = date1.minusYears(5);
        LocalDate date8 = date1.plus(6, ChronoUnit.MONTHS);

        String str1 = date1.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));

        LocalDate date9 = LocalDate.now();
        LocalDate date10 = date9.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date11 = date9.with(TemporalAdjusters.lastDayOfMonth());

        String str2 = date9.format(DateTimeFormatter.BASIC_ISO_DATE);
        String str3 = date9.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate date12 = LocalDate.parse("20140318",DateTimeFormatter.BASIC_ISO_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date13 = LocalDate.of(2014, 3, 18);
        String str4 = date13.format(formatter);
        LocalDate date14 = LocalDate.parse(str4, formatter);

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate date15 = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date15.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        Chronology chronology = Chronology.ofLocale(Locale.CHINA);
        ChronoLocalDate now = chronology.dateNow();
    }
}
