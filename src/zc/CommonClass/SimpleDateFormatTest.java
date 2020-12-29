package zc.CommonClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    /*
    * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    * 1.两个操作：
    * 1.1 格式化：日期--》字符串
    * 1.2 解析：格式化的逆过程，字符串--》日期
    *
    * 2.SimpleDateFormat的实例化
    * */

    public void test1() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf=new SimpleDateFormat();

        //格式化：日期--》字符串
        Date date=new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串--》日期
        String str="12/29/20, 4:19 PM";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //Date date1=sdf.parse(str);
        String format1=sdf1.format(date);//使用指定格式
        System.out.println(format1);
        Date date1=sdf1.parse("2020-12-29 16:33:30");//解析传入的格式要和sdf1格式一致
        System.out.println(date1);
    }


    public static void main(String[] args) throws ParseException {
        new SimpleDateFormatTest().test1();
    }
}
