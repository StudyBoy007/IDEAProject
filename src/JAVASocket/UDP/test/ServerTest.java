package JAVASocket.UDP.test;

import sun.java2d.pipe.SpanIterator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class ServerTest {
    static DatagramSocket socket;


    public static void main(String[] args) {
        try {
            socket = new DatagramSocket(9801);
            byte[]bytes=new byte[1024];
            DatagramPacket packet=new DatagramPacket(bytes, bytes.length);
            System.out.println("*********服务端开始监听**********");
            System.out.println("receive 前packet长度："+packet.getLength());
            System.out.println(packet.getData());
            System.out.println("receive 前packet的Data长度："+packet.getData().length);
            System.out.println("receive 前packet的数组："+ Arrays.toString(packet.getData()));
            socket.receive(packet);
            System.out.println("receive 后packet长度："+packet.getLength());
            System.out.println("receive 后packet的Data长度："+packet.getData().length);
            System.out.println("receive 后packet的数组："+ Arrays.toString(packet.getData()));
            String info=new String(bytes, 0, packet.getLength());

            //获取接收到的packet的data
            String info2=new String(packet.getData(), 0, packet.getData().length);
            String info3=new String(packet.getData(),0,packet.getLength());
            String info4=new String(packet.getData(),0,50);
            System.out.println("我是Server,Client说："+info);
            System.out.println(info2);
            System.out.println(info3);
            System.out.println(info4);

            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(packet.getAddress().getHostName());
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

