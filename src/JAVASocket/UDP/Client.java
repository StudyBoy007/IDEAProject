package JAVASocket.UDP;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        try {
            //1.指定服务器的地址和端口号，发送数据的目的地
            InetAddress address=InetAddress.getLocalHost();
            int port=9999;
            //2.创建发送的数据报
            byte[]datas="用户名为：tom,密码为：66666".getBytes();
            DatagramPacket packet=new DatagramPacket(datas, datas.length, address, port);
            //3.创建DatagramSocket发送数据报
            DatagramSocket socket=new DatagramSocket();
            //4.发送数据报
            socket.send(packet);

            //5.接收服务端反馈的消息
            byte[]datas2=new byte[20];
            DatagramPacket packet1=new DatagramPacket(datas2, datas2.length);
            System.out.println("packet1 receive前："+packet1.getLength());
            System.out.println(Arrays.toString(packet1.getData()));
            socket.receive(packet1);
            //receive后packet就变成接收到的数据包的大小了
            String info=new String(datas2, 0, packet1.getLength());
            System.out.println("packet1 receive后："+packet1.getLength());
            System.out.println("packet1中的字节数组"+packet1.getData().length);
            System.out.println(Arrays.toString(packet1.getData()));
            System.out.println(info);
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
