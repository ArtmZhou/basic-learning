package zc.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试FileInputStream和FileOutputStream的使用
 * 1.文本文件（.txt,.cpp,.java,.c）用字符流
 * 2.非文本文件（.jpg,.png,.mp3,.mp4,.ppt,.avi）用字节流
 * */
public class FileInputOutputStreamTest {
    public void test1() throws IOException {
        FileInputStream fis= null;
        try {
            //1,造文件
            File file=new File("hello.txt");
            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    //4.关闭流
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**对图片的复制操作*/
    public void test2(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcFile=new File("三维.png");
            File destFile=new File("三维1.png");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //抽象成一个函数，可用于复制非文本文件，其实也能复制文本文件，但复制的过程中观察会有乱码，复制完成后观察则没有
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new FileInputOutputStreamTest().test2();
    }
}
