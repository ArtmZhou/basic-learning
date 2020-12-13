package zc.LearningThread;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("vip线程来了");
        }
    }

    public static void main(String[] args) {
        //启动线程
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i==200){
                try {
                    thread.join();//插队
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("main"+i);
        }
    }
}
