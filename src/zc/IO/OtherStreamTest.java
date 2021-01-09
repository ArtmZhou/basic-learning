package zc.IO;


import java.io.*;

/**
 * 1.标准的输入、输出流
 * 1.1
 * System.in：标准的输入流，默认从键盘输入
 * System.out：标准的输出流，默认从控制台输出
 *
 * 1.2
 * System类的setIn(InputStream is)/setOut(PrintStream ps)方式重新指定输入何输出的流
 * */
public class OtherStreamTest {
    //使用System.in实现。System.in--->转换流--->BufferedReader的readLine()
    public void test1(){
        BufferedReader br= null;
        try {
            InputStreamReader isr=new InputStreamReader(System.in);//使用转换流，将输入流转换成字符输入转换流
            br = new BufferedReader(isr);
            while(true){
                String data=br.readLine();
                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase=data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 打印流：printStream   printWriter
     * */
    public void test2(){
        PrintStream ps= null;
        try {
            FileOutputStream fos=new FileOutputStream(new File("ASCII.txt"));
            //创建打印输出流，设置为自动刷新模式（写入换行符或字节”\n“时都会刷新输出缓冲区
            ps = new PrintStream(fos,true);
            if(ps!=null){//把标准输出流（控制台输出）改为文件
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if(i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 数据流
     * DataInputStream和DataOutputStream
     * 用于读取或写出基本数据类型的变量或字符串
     * */
    //将内存中的字符串、基本数据类型的变量写出到文件中
    public void test3() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("dos.txt"));
        dos.writeUTF("artm");
        dos.flush();
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        dos.close();
    }
    //将dos.txt读入 读取的顺序和写入的顺序要一致
    public void test4() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("dos.txt"));

        String name=dis.readUTF();
        int age=dis.readInt();
        boolean isMale=dis.readBoolean();

        System.out.println(name+age+isMale);
        dis.close();
    }

    public static void main(String[] args) throws IOException {
        new OtherStreamTest().test4();
    }
}
