package zc.LearningThread;

//多个线程同时操作同一个对象
//买票的例子

//问题：多个线程操作同一个资源，线程变得不安全，数据紊乱
public class TestThread04 implements Runnable{
    //票数
    private int ticketNumbers=10;

    @Override
    public void run() {
        while (true){
            if(ticketNumbers<=0){
                break;
            }
            try {
                Thread.sleep(300);//延时
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticketNumbers--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread04 t=new TestThread04();

        new Thread(t,"小明").start();
        new Thread(t,"小红").start();
        new Thread(t,"小绿").start();
    }
}
