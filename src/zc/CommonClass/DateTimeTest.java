package zc.CommonClass;

import java.util.Date;

public class DateTimeTest {
    /*system类中的时间*/
    public void test1(){
        long time=System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    /*
    java.util.Date类
        /--java.sql.Date类

    1.两个构造器的使用

    2.两个方法的使用
        >toString():显示当前的年月日时分秒
        >getTime():获取当前Date对象对应的毫秒数时间戳

    3.java.sql.Date对应数据库中的日期类型变量
        >实例化
    */
    public void test2(){
        //构造器一：Date();创建一个当前时间的对象
        Date date1=new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二
        Date date2 = new Date(2019, 3, 16);//已经不建议使用了
        Date date3=new Date(11841419054124L);//创建一个以时间戳为变量的时间

        //创建java.sql.Date对象
        java.sql.Date date4=new java.sql.Date(146174617854414L);
    }
}
