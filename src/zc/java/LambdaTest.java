package zc.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * lambda表达式就是一个函数式接口的实例
 *
 * java内置4大核心函数式接口
 * 消费型接口 Consumer<T>  void accept(T t)
 * 供给型接口 Supplier<T>  T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 * */

public class LambdaTest {
    //消费型接口 Consumer<T>  void accept(T t)
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费了"+aDouble+"元");
            }
        });

        System.out.println("---------------------");
        happyTime(400,money->{
            System.out.println("消费了"+money+"元");
        });
    }

    public void happyTime(double money, Consumer<Double>con){
        con.accept(money);
    }




    //断定型接口 Predicate<T> boolean test(T t)
    public void test2(){
        List<String>list= Arrays.asList("北京","南京","天津","东京","西安","中原");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        System.out.println("-------------------------");
        //lambda表达式
        List<String> filterStrs1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

    //根据给定的规则过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String>list, Predicate<String>pre){
        ArrayList<String>filterList=new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }


    public static void main(String[] args) {
        new LambdaTest().test2();
    }
}
