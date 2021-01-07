package zc.IO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWriterTest {
//    public void test1() throws IOException {
//        //1.实例化File类，指明要操作的文件
//        File file=new File("hello.txt");
//        //2.提供具体的流
//        FileReader fileReader=new FileReader(file);
//
//        //3.数据的读入
//        //read()：返回读入的一个字符，如果达到文件末尾，返回-1
//        int data=fileReader.read();
//        while (data!=-1){
//            System.out.print((char)data);
//            data=fileReader.read();
//        }
//        //4.流的关闭
//        fileReader.close();
//    }
    //不建议使用上面的抛出异常（如果抛出了异常会导致流没关闭进而使得内存泄漏）；
    // 建议使用try-catch-finally，
    //try——catch的默认快捷键是ctrl+alt+t
    public void test1() {
        FileReader fileReader=null;
       try{
       //1.实例化File类，指明要操作的文件
        File file=new File("hello.txt");
        //2.提供具体的流
        fileReader=new FileReader(file);

        //3.数据的读入
        //read()：返回读入的一个字符，如果达到文件末尾，返回-1
        int data=fileReader.read();
        while (data!=-1){
            System.out.print((char)data);
            data=fileReader.read();
        }
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           //4.流的关闭
           try {
               fileReader.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {
//        try {
//            new FileReaderWriterTest().test1();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        new FileReaderWriterTest().test1();
    }
}
