package zc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    //使用反射对Person操作
    public void test1() throws Exception {
        Class clazz=Person.class;
        //1.通过反射创建Person类的对象
        Constructor cons=clazz.getConstructor(String.class,int.class);
        Object obj=cons.newInstance("artm",24);
        Person p=(Person)obj;
        System.out.println(p);
        //2.通过反射调用对象指定属性、方法
        Field age=clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        //3.调用方法
        Method show=clazz.getDeclaredMethod("show");
        show.invoke(p);

        //使用反射调用私有结构
        //调用私有构造器
        Constructor cons1=clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person)cons1.newInstance("zhou");
        System.out.println(p1);
        //调用私有属性
        Field name=clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"jack");
        System.out.println(p1);
        //调用私有方法
        Method showNation=clazz.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1, "China");//相当于p1.showNation("China")
    }

    /**
     * 关于java.lang.Class类的理解
     * 1.类的加载过程：
     *      程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)，接着我们使用
     *      java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程
     *      称为类的加载。加载到内存中的类，我们称为运行时类，此运行时类，就作为Class的一个实例。
     * 2.换句话说，Class的实例就对应着一个运行时类。
     * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
     * */
    //获取Class的实例的方式(掌握前三种)
    public void test2() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1=Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1=new Person("artm",24);
        Class clazz2=p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath) 此方式用得比较多
        Class clazz3=Class.forName("zc.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);//true
        System.out.println(clazz1==clazz3);//true


        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("zc.Person");
        System.out.println(clazz4);
        System.out.println(clazz4==clazz1);//true
    }

    public static void main(String[] args) throws Exception {
        new ReflectionTest().test2();
    }
}


class Person {
    private String name;
    public int age;

    public Person(){};
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name){
        this.name=name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void show(){
        System.out.println("hello");
    }
    private void showNation(String nation){
        System.out.println(nation);
    }

    @Override
    public String toString() {
        return "name:"+name+" age:"+age;
    }

    private static void showDesc(){
        System.out.println("i love you!");
    }

}
