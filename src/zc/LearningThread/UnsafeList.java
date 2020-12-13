package zc.LearningThread;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {
    public static void main(String[] args) {
        List<String>list=new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //同步块，锁住变化的量
               synchronized (list){
                   list.add(Thread.currentThread().getName());
               }
            }).start();
        }
        //尽量休眠长一些，以免还未执行完线程就输出了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
