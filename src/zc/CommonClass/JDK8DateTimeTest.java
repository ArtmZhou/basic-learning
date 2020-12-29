package zc.CommonClass;

import java.time.*;
import java.util.Date;

public class JDK8DateTimeTest {
    public void test1(){
        //无参数时创建的是当前对象
        Date date=new Date();
        System.out.println(date);
        //偏移量
        Date date1=new Date(2020-1900,9-1,8);
        System.out.println(date1);
    }

    /*
    * LocalDate,LocalTime,LocalDateTime的使用*/
    public void test2(){
        //now()获取当前的时间，日期
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);

        //of():设置指定的年月日时分秒，不需要偏移量
        LocalDateTime of = LocalDateTime.of(2020, 12, 29, 20, 00, 00);
        System.out.println(of);

    }

    /*Instant使用
    * 类似于java.util.Date类*/
    public void test3(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年以来的毫秒数
        long milli=instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例
        Instant instant1=Instant.ofEpochMilli(1609244291830L);
        System.out.println(instant1);
    }



    public static void main(String[] args) {
        new JDK8DateTimeTest().test1();
        new JDK8DateTimeTest().test2();
        new JDK8DateTimeTest().test3();
    }
}
