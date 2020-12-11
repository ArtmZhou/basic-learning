package zc.LearningThread;

public class TestThread01 extends Thread {
    //线程入口
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("run线程");
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        TestThread01 testThread01=new TestThread01();

        //调用start()方法开启线程
        testThread01.start();
        /*线程开启不一定立即执行，由CPU调度执行
         * 交替执行
         * */

        for (int i = 0; i < 600; i++) {
            System.out.println("我在学习多线程");
        }

    }
}
