package zc.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 客户端发消息，服务端接收
 * */
//idea默认查看构造器参数的快捷键是ctrl+p
public class TCPClientTest1 {
    //客户端
    public void client() {
        Socket socket= null;
        OutputStream os= null;
        try {
            //1.创建Socket对象，指明服务器的ip和端口号
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("hello,i am client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
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
        new TCPClientTest1().client();
    }
}
