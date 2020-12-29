package zc.CommonClass;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    /*
     * 方式一：创建子类(GregorianCalendar)对象
     * 方式二：调用静态方法getInstance()
     * */
    public void test1(){
        Calendar calendar=Calendar.getInstance();

        //常用方法
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,24);//calendar是可变的
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类--—》Date
        Date date=calendar.getTime();
        System.out.println(date);

        //setTime():Date--》日历类
        Date date1=new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }


    public static void main(String[] args) {
        new CalendarTest().test1();
    }
}
