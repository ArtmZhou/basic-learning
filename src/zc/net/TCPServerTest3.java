package zc.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest3 {
    public void server(){
        Socket socket= null;
        InputStream is= null;
        FileOutputStream fos= null;
        try {
            ServerSocket ss=new ServerSocket(9090);

            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("3D.png"));

            byte[] buffer=new byte[1024];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("接收成功");

            //服务器再给予客户端反馈
            OutputStream os=socket.getOutputStream();
            os.write("服务器已收到，谢谢".getBytes());
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
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
        new TCPServerTest3().server();
    }
}
