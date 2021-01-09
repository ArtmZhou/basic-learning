package zc.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiverTest {
    public void receiver() throws IOException {
        DatagramSocket socket=new DatagramSocket(9090);
         byte[] buffer=new byte[100];
        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        new UDPReceiverTest().receiver();
    }
}
