package zc.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class IteratorTest {
    public void test1(){
        Collection collection=new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new String("Tom"));
        collection.add(false);
        collection.add(new Person("artm",12));
        Iterator iterator=collection.iterator();
        //System.out.println(iterator.next());
        //遍历  推荐使用hasnext()
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //千万不可采用下列方式  会陷入无限循环
//        while(collection.iterator().hasNext()){
//            System.out.println(collection.iterator().next());
//        }

        //移除元素 remove()方法
        Iterator iterator1=collection.iterator();
        while(iterator1.hasNext()){
            Object obj= iterator1.next();
            if(obj.equals("Tom")){
                iterator1.remove();
            }
        }

        //使用for遍历  for(集合元素类型 局部变量：集合对象)
        for(Object obj:collection){
            System.out.println(obj);
        }

        //普通for循环 这样操作s中的元素会变
        System.out.println("-----------round 1-----------");
        String[] s=new String[]{"mm","mm","mm"};
        for (int i = 0; i < s.length; i++) {
            s[i]="gg";
            System.out.println(s[i]);
        }
        //增强for循环 这样操作s中的元素不会变，增强操作一般用于遍历，不要用在修改上
        for(String i:s){
            i="gg";
        }
    }

    public static void main(String[] args) {
        new IteratorTest().test1();
    }
}

class Person implements Comparable{
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name:"+name+" age:"+age;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p=(Person)o;
            return this.name.compareTo(p.name);
        }else{
            throw new RuntimeException();
        }
    }
}