package com.akso.java8.DateApi;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

    @Test
    public void test() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        LocalDateTime time2 = LocalDateTime.of(2019, 07, 8, 15, 30, 30);
        System.out.println(time2);

        time2.plusYears(1);
        System.out.println(time2);
        time2.minusYears(2);
        System.out.println(time2);

        System.out.println(time.getYear());
        System.out.println(time.getMonth());
        System.out.println(time.getDayOfMonth());
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    @Test
    public void test2() {
        Instant instant = Instant.now();

        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getEpochSecond());

        // 相较于ｕｎｉｘa元年的时间
        Instant instant1 = Instant.ofEpochSecond(1000);
        System.out.println(instant1);
    }

    /**
     * Duration 计算２个"时间"之间的间隔
     */
    @Test
    public void test3() {
        Instant instant = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant, instant2);
        System.out.println(duration);

        System.out.println("-----------");

        LocalDateTime ldt = LocalDateTime.now();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        LocalDateTime ldt2 = LocalDateTime.now();
        Duration duration1 = Duration.between(ldt, ldt2);
        System.out.println(duration1.toNanos());
    }

    /**
     * Period : 计算２个"日期" 之间的间隔
     */
    @Test
    public void test4() {
        LocalDate ld = LocalDate.now();

        LocalDate ld2 = LocalDate.of(2018, 12, 1);

        Period p = Period.between(ld, ld2);
        System.out.println(p);
        System.out.println(p.getYears() + "Y" + p.getMonths() + "M" + p.getDays() + "days");
    }

    /**
     * DateTimeFormatter:格式化时间/日期
     */
    @Test
    public void test5() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();

        String str = dateTimeFormatter.format(ldt);

        System.out.println(str);

    }

    /**
     * 字符转时间
     */
    @Test
    public void test6() {
        String dateStr = "2019-07-08 15:23:48";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ld = LocalDateTime.parse(dateStr, dateTimeFormatter);
        System.out.println(ld);
    }

    /**
     * ZoneDate, ZoneDateTime, ZoneTime
     */
    @Test
    public void test7() {
        System.out.println(ZoneId.getAvailableZoneIds());

        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        LocalDate ld = LocalDate.now(ZoneId.of("America/Marigot"));
        System.out.println(ld);
    }

    @Test
    public void test8() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(ldt));
        LocalDateTime ldt2 = ldt.plusYears(2);
        System.out.println(dateTimeFormatter.format(ldt2));
        LocalDateTime ldt3 = ldt.plusMonths(10);
        System.out.println(dateTimeFormatter.format(ldt3));
        LocalDateTime ldt4 = ldt.plusDays(100);
        System.out.println(dateTimeFormatter.format(ldt4));
        LocalDateTime ldt5 = ldt.plusSeconds(1000);
        System.out.println(dateTimeFormatter.format(ldt5));
    }
}
