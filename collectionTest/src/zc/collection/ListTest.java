package zc.collection;

/*
* list接口，储存有序的可重复的数据
*   /-->arraylist 作为list接口的主要实现类，线程不安全，效率高，底层使用Object[]储存
*   /-->linkedlist  底层使用双向链表储存
*   /-->vector  作为list接口的古老实现类，线程安全，效率低，底层使用Object[]储存
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
   public void test1(){
       ArrayList list=new ArrayList();
       list.add(1);
       list.add(2);
       list.add("qq");
       list.add(new Person("artm",24));
       System.out.println(list.toString());

       //add(int index,Object ele)：在index位置插入ele元素
       list.add(1,"ww");
       System.out.println(list);

       //addAll(int index,Collection eles):从index位置开始将eles中所有元素添加
       List list1= Arrays.asList(1,2,3);
       list.addAll(list1);
       System.out.println(list);
//       list.add(list1);
//       System.out.println(list);

       //indexof(Object obj):返回obj在集合中首次出现的位置
       //remove(int index):移除指定index位置的元素，并返回此元素
       //set(int index,Object ele):设置指定index位置的元素ele
   }

    public static void main(String[] args) {
        new ListTest().test1();
    }
}
