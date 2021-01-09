package zc.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientTest3 {
    public void client(){
        Socket socket= null;
        OutputStream os= null;
        FileInputStream fis= null;
        try {
            //1造socket
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            //客户端socket的输出流
            os = socket.getOutputStream();
            //2文件的输入流
            fis = new FileInputStream(new File("E:\\workspace\\githubcode\\basic learning\\三维.png"));
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            System.out.println("发送完毕");
            //关闭数据的输出,不设置客户端输出流关闭的话客户端会一致阻塞
            socket.shutdownOutput();

            //接收来自服务器的数据，并显示在控制台上
            InputStream is=socket.getInputStream();

            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buffer1=new byte[10];
            int len1=0;
            while((len=is.read(buffer))!=-1){
                baos.write(buffer1,0,len1);
            }
            System.out.println(baos.toString());
            baos.close();

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
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TCPClientTest3().client();
    }
}
