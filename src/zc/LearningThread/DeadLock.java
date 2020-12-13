package zc.LearningThread;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1=new Makeup(0,"Rose");
        Makeup g2=new Makeup(1,"Juli");
        g1.start();
        g2.start();
    }
}

class Lipstick{

}

class Mirror{

}

class Makeup extends Thread{
    static Lipstick lipstick=new Lipstick();
    static  Mirror mirror=new Mirror();

    int choice;
    String girlName;

    Makeup(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else{
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(1000);
            }
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}