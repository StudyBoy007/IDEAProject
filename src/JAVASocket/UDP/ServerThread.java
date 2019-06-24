package JAVASocket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerThread extends Thread {
    DatagramSocket socket = null;
    DatagramPacket packet = null;

    public ServerThread(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
    }

    @Override
    public void run() {
        byte[] datas = packet.getData();
        System.out.println(datas.length);
        try {
            System.out.println("接收信息包的数据包的长度为：" + packet.getLength());
            String info = new String(datas, 0, packet.getLength());
            System.out.println("我是服务器，客户端说：" + info);

            //5.服务器响应客户端数据
            //1.获取接收到的客户端发来的数据报中包含的信息，其中端口号和inetaddress，是客户端的参数
            InetAddress address = packet.getAddress();
            System.out.println(address);
            int port = packet.getPort();
            System.out.println(port);
            //创建数据包发送回给客户端
            byte[] datas2;
            datas2 = "欢迎您~".getBytes();
            DatagramPacket packet1 = new DatagramPacket(datas2, datas2.length, address, port);
            //send
            socket.send(packet1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (socket != null)
//                socket.close(); //这里不向是tcp accept每监听到一个客户端就创建一个socket，因为这里的socket是共有的，如果这里关了
            //那么就只能接收一个客户端的信息，接收到了就关闭了socket，后续的客户端就链接不到这个服务器了
        }


    }
}
