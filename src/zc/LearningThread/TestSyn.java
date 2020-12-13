package zc.LearningThread;

public class TestSyn implements Runnable{
    //票数
    private int ticketNumbers=10;
    private boolean flag=true;
    @Override
    public void run() {
        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //synchronized同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        if(ticketNumbers<=0){
           flag=false;
           return;
        }
        //模拟延时
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticketNumbers--+"票");
    }

    public static void main(String[] args) {
        TestSyn t=new TestSyn();

        new Thread(t,"小明").start();
        new Thread(t,"小红").start();
        new Thread(t,"小绿").start();
    }
}
