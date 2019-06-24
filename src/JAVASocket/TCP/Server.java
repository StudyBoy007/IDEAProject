package JAVASocket.TCP;
/**
 * 1.在客户端或者服务端通过socket.shutdownOutput()都是单向关闭的，即关闭客户端的输出流并不会关闭服务端的输出流，所以是一种单方向的关闭流；
 * 2.通过socket.shutdownOutput()关闭输出流，但socket仍然是连接状态，连接并未关闭
 * 3.如果直接关闭输入或者输出流，即：in.close()或者out.close()，会直接关闭socket
 * 4.ServerSocket的close()方法使服务器释放占用的端口，并且断开与所有客户的连接。
 * 当一个服务器程序运行结束时，即使没有执行ServerSocket的close()方法，操作系统
 * 也会释放这个服务器占用的端口。因此，服务器程序并不一定要在结束之前执行ServerSocket的close()方法。
 */

import sun.java2d.pipe.SpanIterator;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 * 服务端
 */
public class Server {


    public static void main(String[] args) {
        int count=0;
        try {
            ServerSocket serverSocket;
            //1.创建服务端的ServerSocket的实例
            serverSocket = new ServerSocket(8888);//端口建议为1023往后的端口
            //2.监听，调用accept方法
            System.out.println("*************服务器即将启动，正在监听客户端的请求*************");
            //循环监听客户端的请求，一旦有一个客户端发送请求，就立马建立一个socket链接
            Socket socket=null;
            while (true) {
                //监听，当监听到客户端发来的请求时，建立连接，生成socket，在没有请求前一直处于阻塞状态
                 socket = serverSocket.accept();
                 //建立线程
                ServerThread serverThread=new ServerThread(socket);
                serverThread.setPriority(3);//设置线程优先级
                serverThread.start(); //start方法会创建一个新线程，并且运行run方法中的数据
                count++;
                System.out.println("客户端的数量为："+count);
                //获取当前连接的客户端的inetaddress实例
                InetAddress address=socket.getInetAddress();
                System.out.println("当前"+count+"号客户端的inetAddress实例为："+address);
                System.out.println("当前"+count+"号客户端的ip地址为："+address.getHostAddress());
                System.out.println("当前"+count+"号客户端的名称为："+address.getHostName());
//                InetAddress address1=socket.getLocalAddress();
//                System.out.println("服务器本地的address实例为："+address1);
            }
//            //3.获取字节输入流，获取客户端发来的信息
//            InputStream is = socket.getInputStream();
//            //字节流获取
////            byte[]bytes=new byte[8*1024];
////            int i;
////            while ((i=is.read(bytes, 0, bytes.length))!=-1){
////                String str=new String(bytes);
////                System.out.println(str);
////            }
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String info = null;
//            while ((info = br.readLine()) != null) {
//                System.out.println("我是服务器，客户端说" + info);
//            }
//            socket.shutdownInput();
//            //4.获取输出流，响应客户端的请求
//            OutputStream os=socket.getOutputStream();
//            PrintWriter pw=new PrintWriter(os);
//            pw.write("欢迎你~");
//            pw.flush();
//            //5.关闭资源
//            socket.shutdownOutput();
//            pw.close();
//            os.close();
//            br.close();
//            isr.close();
//            is.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
