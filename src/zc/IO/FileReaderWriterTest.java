package zc.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        //read(char[] str)的测试
    public void test2(){
        FileReader fileReader=null;
        try{
            //1.实例化File类，指明要操作的文件
            File file=new File("hello.txt");
            //2.提供具体的流
            fileReader=new FileReader(file);

            //3.数据的读入
            //read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cbuf=new char[5];
            int len;//len用来表示读入的长度
            while ((len=fileReader.read(cbuf))!=-1){
                //方式一
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
                //下面这个是错误的写法
//                String str=new String(cbuf);
//                System.out.println(str);
                //可改为
//                String str=new String(cbuf,0,len);
//                System.out.println(str);

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4.流的关闭
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 从内存中写出数据到硬盘的文件中
    *
    * 说明：
    * 1.输出操作，对应的File可以不存在
    * 2.如果不存在，在输出的过程中会自动创建。
    *   如果存在.此时看流的构造器
    *
    *
    * */
    public void test3() throws IOException {
        //1.提供File类的对象，指明写出到的文件
        File file=new File("hellov1.txt");
        //2.提供FileWriter的对象，用于数据的写出
        FileWriter fw=new FileWriter(file,false);//参数append（默认false）：false表示不追加，直接覆盖；true表示追加内容
        //3.写出的操作
        fw.write("i love you!\n");
        fw.write("i still love you!");
        //4.流资源的关闭
        fw.close();
    }

    //创建一个读入和写出
    public void test4() {
        FileReader fr= null;
        FileWriter fw= null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile=new File("hello.txt");
            File desrFile=new File("helloCopy.txt");
            //2.创建流的对象，输入流和输出流
            fr = new FileReader(srcFile);
            fw = new FileWriter(desrFile);
            //3.数据的读入和写出
            char[] cbuf=new char[5];
            int len;//len用来表示读入的长度
            while((len=fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    public static void main(String[] args) throws IOException {
//        try {
//            new FileReaderWriterTest().test1();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //new FileReaderWriterTest().test1();
        new FileReaderWriterTest().test4();
    }
}
