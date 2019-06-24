package JAVASocket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP的服务端
 */
public class Server {
    public static void main(String[] args) {
        int count = 0;
        try {
            //1.创建服务器端DatagramSocket，用来指定服务器的端口
            DatagramSocket socket = socket = new DatagramSocket(9999);
            //2.创建DatagramPacket，用来接收客户端发送的数据
            byte[] datas = new byte[1024];//创建字节数组，指定创建接收信息的数据包的大小
            System.out.println("*************服务器即将启动，正在等待接收客户端的数据*************");
            while (true) {
                DatagramPacket packet = new DatagramPacket(datas, datas.length);
                socket.receive(packet);//没有执行接收到packet就卡死在这里，阻塞状态
                ServerThread thread = new ServerThread(socket, packet);
                thread.start();
                count++;
                System.out.println("客户端的数量为：" + count);
            }
//            //2.创建DatagramPacket，用来接收客户端发送的数据
//            byte[]datas=new byte[1024];//创建字节数组，指定创建接收信息的数据包的大小
//            DatagramPacket packet=new DatagramPacket(datas,datas.length);
//            //3.接收客户端发送的数据
//            System.out.println("*************服务器即将启动，正在等待接收客户端的数据*************");
//            socket.receive(packet);//在没有接收到数据报之前一直处于阻塞状态
//            //4.读取数据,在receive方法之前，packet的长度还是和字节数组大小一致，receive方法后，packet的长度和接收到的数据长度一致
//            //说明receive后，packet就变成了客户端发送来的packet，而不是原先的packet，但是要注意的是原先定义的packet数据报的大小
//            //一定要足够大，否则接收不完全客户端发送来的数据
//            System.out.println("接收信息包的数据包的长度为："+packet.getLength());
//            String info=new String(datas, 0, packet.getLength());
//            System.out.println("我是服务器，客户端说："+info);
//
//
//            //5.服务器响应客户端数据
//            //1.获取接收到的客户端发来的数据报中包含的信息，其中端口号和inetaddress，是客户端的参数
//            InetAddress address=packet.getAddress();
//            int port=packet.getPort();
//            //创建数据包发送回给客户端
//            byte[]datas2=new byte[199];
//            datas2="欢迎您~".getBytes();
//            DatagramPacket packet1=new DatagramPacket(datas2, datas2.length, address, port);
//            //send
//            socket.send(packet1);
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
