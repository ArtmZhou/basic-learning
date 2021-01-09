package zc.IO;

import java.io.*;

/**
 * 1缓冲流的使用
 * 2作用：提升流的读取的写入速度
 * */
public class BufferedTest {

    /**
     * 实现非文本文件的复制
     * */
    public void test1(){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1造文件
            File srcFile=new File("三维.png");
            File destFile=new File("三维2.png");
            //2造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2造缓冲流(处理流)
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3复制的细节：读取、写入
            byte[] buffer=new byte[10];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4资源关闭：先关闭外层的流，再关内层的流
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：在关闭外层流的同时，内层流也会自动进行关闭。关于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
        }
    }


    public static void main(String[] args) {
        new BufferedTest().test1();
    }
}
