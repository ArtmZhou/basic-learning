package zc.generic;


import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 *      1.jdk5.0新增的特性
 *      2.泛型的类型必须是类，不能是基本数据类型
 *      3.如果实例化没有指明泛型类型，则默认为java.lang.Object
 *
 * 自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 创建泛型数组时，不能直接T[] array=new T[10];这样会编译报错
 * 可以T[] array=(T[]) new Object[10];
 * */
public class GenericTest<T> {
    T testT;
    int score;

    public GenericTest(T testT, int score) {
        this.testT = testT;
        this.score = score;
    }


    //泛型方法
   public <E> List<E> func(E[] arr){
       ArrayList<E> list=new ArrayList<>();
       for(E i:arr){
           list.add(i);
       }
       return list;
   }


    /**通配符：？
    添加（写入）：对于List<?>不能向其内部添加数据，除了null之外

    有限制条件的通配符的使用：
    ？ extends Person    ------->? extends理解成<=
    ？ super Person      ------->? super理解成>=
    */
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{1,2,3,4};
        List<Integer> list=new GenericTest<String>("ss",9).func(arr);
        System.out.println(list);
    }
}
