package JAVASocket.TCP;

import org.dom4j.io.OutputFormat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {

        try {
            //1.创建客户端Socket，指定服务器的地址和端口)
            InetAddress address=InetAddress.getLocalHost();
            Socket socket = new Socket(address, 8888);
//            Socket socket = new Socket("localhost", 8888);
            //2.获取输出流，向服务端发送信息
            OutputStream os=socket.getOutputStream();
            //字节流输出
//            os.write("用户名：蔡泽球，密码:czqcomeon".getBytes());
            PrintWriter pw=new PrintWriter(os);
            pw.write("用户名为：蔡泽球，密码为:czqcomeon");
            pw.flush();
            //3.关闭输出流
            socket.shutdownOutput();
            //4.获取输入流，获取服务端给客户端的响应
            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String line;
            while ((line=br.readLine())!=null){
                System.out.println("我是客户端，服务端说："+line);
            }
            socket.shutdownInput();
            //5.关闭流资源
            br.close();
            isr.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
