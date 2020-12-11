package zc.LearningThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟网络延时：放大问题的发生性
 * */
public class TestSleep {
    public static void main(String[] args) {

        try{
            down(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //获取当前时间
        Date startTime=new Date(System.currentTimeMillis());//获取系统当前时间
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime=new Date(System.currentTimeMillis());//更新当前时间
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //倒计时
    public static void down(int num) throws InterruptedException{
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }
}
