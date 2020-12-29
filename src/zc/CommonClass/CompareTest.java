package zc.CommonClass;

import java.util.Arrays;

public class CompareTest {
    /*
    * Comparable接口的使用
    * 1.像String，包装类等实现Comparable接口，重写compareTo()方法
    */
    public void test1(){
        String[] arr=new String[]{"AA","BB","DD","GG"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        new CompareTest().test1();
    }
}
