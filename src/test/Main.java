package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Create by czq
 * time on 2019/6/23  10:16
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime parse = LocalDateTime.parse("2019-06-23 10:19:09", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(parse);

        System.out.println(LocalDate.now().toEpochDay() - LocalDate.of(1998, 11, 18).toEpochDay());
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        LocalDate now1 = LocalDate.now();
        //LocalDate parse1 = LocalDate.parse("2019年06月23日", DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
//        System.out.println(parse1);
        System.out.println(now1.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));

    }
}
