package zc.LearningThread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("run线程");
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        MyRunnable myRunnable=new MyRunnable();

        //创建线程对象，通过线程对象来启动我们的线程，代理
//        Thread thread=new Thread(myRunnable);
//        thread.start();

        new Thread(myRunnable).start();

        for (int i = 0; i < 600; i++) {
            System.out.println("我在学习多线程");
        }
    }
}
