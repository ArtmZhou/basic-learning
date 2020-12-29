package zc.CommonClass;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StringTest1 {
    /*
    * string和基本数据类型、包装类的转换
    * string--》基本数据类型、包装类：调用包装类的静态方法：parseXxx（str）
    * */
    public void test1(){
        String str1="123";
        //int num=(int)str1;//这样是错误的
        int num=Integer.parseInt(str1);
    }


    /*
    * string和char[]之间的转换
    * string--》char[]：调用string的toCharArray()
    * char[]--》string：调用string的构造器
    * */
    public void test2(){
        String str1="abc123";
        char[] chars=str1.toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }

        char[] arr=new char[]{'1','2','w'};
        String str2=new String(arr);
    }

    /*
    * 编码：string--》byte[]：调用string的getBytes()
    * 解码：byte[]--》string：调用string的构造器
    *
    * 编码：字符串--》字节（看得懂--》看不懂的二进制数据）
    * 解码：编码的逆过程，字节--》字符串（看不懂的二进制数据--》看得懂）
    * */
    public void test3() throws UnsupportedEncodingException {
        String str1="abc123中国";
        byte[] bytes=str1.getBytes();//使用默认字符集，进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks=str1.getBytes("gbk");//使用gbk字符串进行编码
        System.out.println(Arrays.toString(gbks));

        String str2=new String(bytes);//使用默认字符串进行解码
        System.out.println(str2);

    }
}
