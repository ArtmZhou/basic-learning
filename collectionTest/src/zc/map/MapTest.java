package zc.map;

import java.util.*;

/**
 * /----map:双列数据，储存key-value对的数据
 *      /----HashMap:作为map的主要实现类，线程不安全，效率低，存储null的key-value(key和value都可以为null）
 *          /----linkedHashMap:保证按照添加的时候的顺序遍历，对于频繁的遍历，推荐linkedHashMap
 *      /----TreeMap：底层使用红黑树实现 保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或者定制排序
 *      /----HashTable：作为古老的实现类，线程安全，效率低，不能存储null的key-value
 *          /----Properties：常用来处理配置文件。key和value都是String类型
 *
 *
 *   面试题
 *   1.HashMap的底层实现原理？
 *   2.HashMao和HashTable的异同？
 *   3.CurrentHashMap和HashTable的异同？
 *
 *
 *   map结构理解
 *   map中的key：无序的，不可重复的，使用set存储所有的key----->key所在的类需要重写equals()和hashCode()
 *   map中的value：无序的，可重复的，使用collection存储所有的value--->value所在的类要重写equals()
 *   一个键值对：key-value构成了一个Entry对象
 *   map中的entry：无序的，不可重复的，使用set存储所有的entry
 *
 *
 *   HashMap的底层实现原理，以jdk7为例
 *   HashMap map=new HashMap();
 *   在实例化以后，底层创建了长度为16的一维数组 Entry[] table
 *   map.put(key1,value1)
 *   首先调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算得到在Entry数组中的存放位置
 *   如果此位置数据为空，则key1-value1添加成功-------情况1
 *   如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表的形式存在）），比较key1和已经存在的一个或多个数据的哈希值：
 *      如果key1的哈希值和已经存在的数据的哈希值都不相同，则key1-value1添加成功---------情况2
 *      如果key1的哈希值和已经存在的某个数据（key2-value2）的哈希值相同，继续比较调用key1所在类的equals(key2):
 *          如果equals()返回false：此时key1-value1添加成功---------情况3
 *          如果equals()返回true：此时使用value1替换value2
 *      补充：关于情况2和情况3，此时key1-value1和原来的数据以链表的方式存储
 *      在不断的添加过程中，会涉及到扩容，一般为原来的2倍，并将原来的数据复制过来
 *
 *   jdk8相比较于jdk7在底层实现的不同：
 *   1.new HashMao()：底层没有创建一个长度为16的Entry[]数组
 *   2.jdk8底层的数组是Node[]，而非Entry[]
 *   3.首次调用put()方法时，底层创建长度为16的数组
 *   4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数>8且当前数组的长度>64时
 *      此时此索引位置上的所有数据改为使用红黑树存储。
 */
public class MapTest {
    public void test1(){
        //添加
        Map map=new HashMap();
        map.put("aa",1123);
        map.put(11,"Eqeqeq");
        map.put(12,121);
        //修改
        map.put("aa",677);
        System.out.println(map);

        //删除
        Object value=map.remove(11);
        System.out.println(value);
        System.out.println(map);
        //获取
        System.out.println(map.get(12));

        //boolean containsKey()
        //boolean containsValue()

        //遍历所有的key集:keySet()
        Set set=map.keySet();
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values=map.values();
        for(Object obj:values){
            System.out.println(obj);
        }

        //遍历所有的key-value：entrySet()
        Set entrySet=map.entrySet();
        Iterator iterator1=entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj=iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry=(Map.Entry)obj;//注意这里Map.Entry是map类中定义的内部静态接口
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按key进行排序：自然排序，定制排序
    public void test2(){
        TreeMap map=new TreeMap();
        Person p1=new Person("artm",24);
        Person p2=new Person("yqeq",25);
        Person p3=new Person("qqhd",26);
        map.put(p1,89);
        map.put(p2,97);
        map.put(p3,90);

        Set entrySet=map.entrySet();
        Iterator iterator1=entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj=iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry=(Map.Entry)obj;//注意这里Map.Entry是map类中定义的内部静态接口
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }

    }

    //TreeMap的定制排序
    public void test3(){
        TreeMap map=new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person x1=(Person)o1;
                    Person x2=(Person)o2;
                    return Integer.compare(x1.getAge(), x2.getAge());
                }
                throw new RuntimeException();
            }
        });
        Person p1=new Person("artm",24);
        Person p2=new Person("yqeq",23);
        Person p3=new Person("qqhd",26);
        map.put(p1,89);
        map.put(p2,97);
        map.put(p3,90);

        Set entrySet=map.entrySet();
        Iterator iterator1=entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj=iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry=(Map.Entry)obj;//注意这里Map.Entry是map类中定义的内部静态接口
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }

    public static void main(String[] args) {
        //new MapTest().test1();
        new MapTest().test2();
        new MapTest().test3();
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