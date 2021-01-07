package zc.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public void test1(){
        List list=new ArrayList();
        list.add(131);
        list.add(1311);
        list.add(152);
        list.add(12);
        list.add(-14);
        list.add(251);
        System.out.println(list);
        //反转
        Collections.reverse(list);
        System.out.println(list);
        //打乱
        Collections.shuffle(list);
        System.out.println(list);

        //排序 sort(List)  sort(List,Comparator)
        Collections.sort(list);
        System.out.println(list);

        //交换 swap(List,int,int)将list中的i处和j处元素交换
        Collections.swap(list,1,3);
        System.out.println(list);
        //int frequency(Collection,Object)：返回指定集合中指定元素的出现次数
        //void copy(List dest,List src):将src中的内容复制到dest中

    }

    public static void main(String[] args) {
        new CollectionsTest().test1();
    }
}
