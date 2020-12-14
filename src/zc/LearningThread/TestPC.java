package zc.LearningThread;

import com.sun.jdi.PathSearchingVirtualMachine;

/**
 * 测试：生产者消费者模型--》利用缓冲区解决：管程法
 * 生产者，消费者，产品，缓冲区
 * */
public class TestPC {
    public static void main(String[] args) {
        SynContainer container=new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer container=new SynContainer();

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"件商品");
            container.push(new Production(i));
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer container=new SynContainer();

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了"+i+"件商品");
            container.pop();
        }
    }
}

//产品
class Production{
    int id;//产品编号                                            

    public Production(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //需要一个容器大小
    Production[] productions=new Production[10];
    //容器计数器
    int count=0;

    //生产者放入产品
    public synchronized void push(Production production){
        //如果容器满了，就需要等待消费者消费
        if(count==productions.length){
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没满，我们需要丢入产品
        productions[count]=production;
        count++;

        //可以通知消费者消费了
        this.notifyAll();

    }

    //消费者消费产品
    public synchronized Production pop(){
        //判断能否消费
        if(count==0){
             //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //如果可以消费
        count--;
        Production production=productions[count];

        //消费完了，通知生产者生产
        this.notifyAll();

        return production;
    }
}