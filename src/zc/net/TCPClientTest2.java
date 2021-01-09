package zc.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 实现TCP网络编程
 *  客户端发送文件给服务端，服务端将文件保存在本地
 * */
public class TCPClientTest2 {
    public void client(){
        Socket socket= null;
        OutputStream os= null;
        FileInputStream fis= null;
        try {
            //1造socket
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os = socket.getOutputStream();
            //2输入流
            fis = new FileInputStream(new File("E:\\workspace\\githubcode\\basic learning\\三维.png"));
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
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
        new TCPClientTest2().client();
    }
}
