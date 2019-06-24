package JAVASocket.UDP.test;

import java.io.IOException;
import java.net.*;

public class ClientTest {
    public static void main(String[] args) {
        try {
            InetAddress address=InetAddress.getLocalHost();
            int port=9801;
            byte[]dataes="用户名：蔡泽球，密码：980114".getBytes();
            System.out.println(dataes.length);
            DatagramPacket packet=new DatagramPacket(dataes, dataes.length, address,port );
            DatagramSocket socket=new DatagramSocket();
            System.out.println("********客户端发送数据**********");
            socket.send(packet);
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
