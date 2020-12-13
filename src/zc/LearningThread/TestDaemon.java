package zc.LearningThread;

/**
 * 测试守护线程*/
public class TestDaemon {
    public static void main(String[] args) {
        World world=new World();
        YouYou youYou=new YouYou();

        Thread thread=new Thread(world);
        thread.setDaemon(true);//默认是false，正常的线程都是false
        thread.start();//守护线程启动

        new Thread(youYou).start();//用户线程启动
    }
}

class World implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("世界一直存在！");
        }
    }
}

class YouYou implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("你每一年都很快乐！");
        }
        System.out.println("=======bye=========");
    }
}