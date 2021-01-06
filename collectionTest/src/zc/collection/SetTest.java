package zc.collection;

/*set接口：储存无序的、不可重复的数据
*   /-->hashset:作为set接口的主要实现类，线程不安全，可以储存null值
*       /-->linkedhashset:作为hashset的子类；遍历其内部数据的时候，可以按照添加的顺序遍历
*   /-->treeset:可以按照添加对象的指定属性，进行排序
*
*
* hashset添加元素：首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
* 此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），
* 判断数组此位置上是否已经有元素：
*   /如果此位置上没有其他元素，则元素a添加成功------>情况1
*   /如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a和元素b的hash值
*       /如果hash值不相同，则元素a添加成功--------->情况2
*       /如果hash值相同，进而需要调用元素a所在类的equals()方法
*           equals()返回true，元素a添加失败
*           equals()返回false，元素a添加成功-------->情况3
* 对于添加成功的情况2，3，元素a与已经存在指定索引位置上数据以链表的方式存储
* */

import java.util.*;

public class SetTest {
    public void test1(){
        //LinkedHashSet是HashSet的子类，方便频繁遍历
        Set set=new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add("aaa");
        set.add(new Person("ARTM",24));
        set.add(new Person("ARTM",24));
        set.add(new Person("ARTM",24));

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void test2(){
        /*
        * 向TreeSet中添加元素只能是相同的类的对象*/

        //TreeSet中添加自定义类，一定要指定排序方式
        //自然排序（实现Comparable接口）：自定义类一定要实现Comparable接口i并实现其中的compareTo()方法
        //定制排序（Comparator）：在创建treeset的时候就指定一个Comparator
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person&&o2 instanceof Person){
                    Person p1=(Person)o1;
                    Person p2=(Person)o2;
                    //Integer.compare()：整形包装类的比较方法
                    return Integer.compare(p1.getAge(),p2.getAge());
                }else {
                    throw new RuntimeException("类型不正确");
                }
            }
        };

        //TreeSet set=new TreeSet();
        TreeSet set=new TreeSet(comparator);
//        set.add(123);
//        set.add(456);
//        set.add(-124);
//        set.add(3434);
        set.add(new Person("a",12));
        set.add(new Person("a",12));
        set.add(new Person("a",12));
        set.add(new Person("a",12));//treeset中只要内容相同就不会再次添加
        set.add(new Person("b",124));
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        new SetTest().test1();
        new SetTest().test2();
    }
}
