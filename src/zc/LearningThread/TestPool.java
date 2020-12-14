package zc.LearningThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建
 * */

public class TestPool {
    public static void main(String[] args) {
        //1.创建线程池服务
        //ewFixedThreadPool参数为线程池大小
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        //执行
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        //关闭连接
        executorService.shutdown();
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}