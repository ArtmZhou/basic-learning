package zc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class FieldTest {
    public void test1(){
        Class clazz=Person.class;

        //获取属性结构
        //getFields()：获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields=clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("----------------------");
        //getDeclaredFields()：获取当前运行时类中声明的所有属性。（不包含父类中的）
        Field[] declaredField=clazz.getDeclaredFields();
        for(Field f:declaredField){
            System.out.println(f);
        }

        System.out.println("----------------------");
        //获取权限修饰符、数据类型、变量名
        for(Field f:declaredField){
            //1.权限修饰符
            int modifiers = f.getModifiers();//用数字代表权限
            System.out.print(Modifier.toString(modifiers)+"\t");//Modifier的静态方法可以得到权限修饰符

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName()+"\t");

            //3.变量名
            String name = f.getName();
            System.out.print(name);

            System.out.println();
        }

        System.out.println("----------------------");
        //获取运行时类的方法结构
        //getMethods()获取当前运行时类及其父类所有的public方法
        Method[] methods = clazz.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }
        System.out.println("----------------------");
        //getDeclaredMethods()获取当前运行时类中声明的方法，不包含父类的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m:declaredMethods){
            System.out.println(m);
        }

        System.out.println("----------------------");
        //获取构造器
        //getConstructors()获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }
        System.out.println("----------------------");
        //getDeclaredConstructors()获取当前运行时类中所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c:declaredConstructors){
            System.out.println(c);
        }

        /*
        Class[] interfaces = clazz.getInterfaces();获取运行时类接口
        Class[] interfaces = clazz.getSuperclass().get Interfaces();获取运行时父类实现的接口
        Package aPackage = clazz.getPackage();获取运行时类所在的包
        Annotation[] annotations = clazz.getAnnotations();获取运行时类声明的注解
         */

    }

    public static void main(String[] args) {
        new FieldTest().test1();
    }
}
