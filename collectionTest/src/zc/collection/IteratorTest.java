package zc.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
    }

    public static void main(String[] args) {
        new IteratorTest().test1();
    }
}

class Person{
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
}