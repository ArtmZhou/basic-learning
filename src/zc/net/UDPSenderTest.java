package zc.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderTest {
    public void sender() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        String str="我是UDP发送端！";
        byte[] data=str.getBytes();
        InetAddress inet=InetAddress.getLocalHost();
        DatagramPacket packet=new DatagramPacket(data,0,data.length,inet,9090);
        socket.send(packet);
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        new UDPSenderTest().sender();
    }
}
