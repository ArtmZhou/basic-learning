package zc.IO;

import java.io.*;

/**
 * ObjectInputStream和ObjectOutputStream
 * 序列化与反序列化
 * 用于存储和读取基本数据类型或对象的处理流
 * 自定义类需要满足如下要求，才可序列化
 *   1.实现Serializable接口(标识接口)
 *   2.当前类提供一个全局常量：serialVersionUID
 *   3.除了当前Person类要实现上述操作，还得保证其内部所有属性同样是可序列化的
 *   4.ObjectInputStream和ObjectOutputStream不能序列化static和transient修饰的成员变量
 * */
public class ObjectInputOutputStreamTest {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectInputStream实现
     * 要想一个Java对象是可序列化的，需要满足一定要求
     * */
    public void test1(){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("i love you!"));//一个String对象
            oos.flush();
            oos.writeObject(new Person("artm",24));//一个自定义对象
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 反序列化
     * */
    public void test2(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj=ois.readObject();
            String str=(String)obj;
            System.out.println(obj);
            Person p=(Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
//        new ObjectInputOutputStreamTest().test1();
        new ObjectInputOutputStreamTest().test2();
    }
}

/**
 * Person类需要满足如下要求，才可序列化
 * 1.实现Serializable接口(标识接口)
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类要实现上述操作，还得保证其内部所有属性同样是可序列化的
 * */
class Person implements Serializable{
    public static final long serialVersionUID=24251535525L;

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "name:"+name+" age:"+age;
    }
}