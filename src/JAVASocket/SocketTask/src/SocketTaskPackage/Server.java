package JAVASocket.SocketTask.src.SocketTaskPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Socket socket;

    public void serverStart() {
        try {
            ServerSocket serverSocket = new ServerSocket(8099);
            System.out.println("******服务器启动，正在监听客户端的请求******");
            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                ServerThread st = new ServerThread(socket);
                st.setPriority(4);
                st.start();
                count++;
                System.out.println("我是服务端,我已经完成了"+count+"次操作了");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
