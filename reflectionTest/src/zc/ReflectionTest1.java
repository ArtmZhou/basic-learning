package zc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest1 {
    public void test1() throws Exception {
        Class clazz=Person.class;
        //创建运行时类的对象
        Person p=(Person)clazz.newInstance();
//        用构造器创建
//        Constructor constructor = clazz.getConstructor(String.class,int.class);
//        Object obj = constructor.newInstance("artm", 24);
//        Person p=(Person)obj;

        //获取指定属性:要求运行时类的属性声明为public
        Field age=clazz.getField("age");
        /*
        * 设置当前属性的值
        * set():参数1：指明设置那个对象的属性  参数2：将此属性值设置成多少
        * */
        age.set(p,25);
        /*
         * 获取当前属性的值
         * get():参数1：指明设置那个对象的属性
         * */
        int pAge =(int)age.get(p);

        System.out.println(p);
    }


    public void test2() throws Exception {
        Class clazz=Person.class;
        //创建运行时类的对象
        Person p=(Person)clazz.newInstance();

        //getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //setAccessible(true)保证当前属性是可访问的
        name.setAccessible(true);
        //设置属性
        name.set(p,"jack");
        //获取属性
        System.out.println(name.get(p));
    }


    /*
    * 如何操作运行时类中指定的方法
    * */
    public void test3() throws Exception {
        Class clazz=Person.class;
        //创建运行时类的对象
        Person p=(Person)clazz.newInstance();

        //1.获取指定的方法
        //getDeclaredMethod()  参数1：指明获取方法的名称  参数2：指明获取方法的形参列表
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        //保证当前方法是可访问的
        showNation.setAccessible(true);
        //invoke()  参数1：方法的调用者  参数2：给方法形参赋值的实参
        //invoke()的返回值即为对应类中调用的放啊的返回值
        showNation.invoke(p,"China");//返回值为showNation()的返回值

        System.out.println("--------------如何调用静态方法----------------");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用运行时类中的方法没有返回值，则invoke()返回null
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);
    }


    /*
    * 如何调用运行时类中的指定构造器
    * */
    public void test4() throws Exception {
        Class clazz=Person.class;

        //1.获取指定的构造器
        //getDeclaredConstructor() 参数：指明构造器的参数列表
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        //2.保证此构造器是可访问的
        declaredConstructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person artm = (Person) declaredConstructor.newInstance("artm");
        System.out.println(artm);
    }

    public static void main(String[] args) throws Exception {
        new ReflectionTest1().test4();
    }
}
