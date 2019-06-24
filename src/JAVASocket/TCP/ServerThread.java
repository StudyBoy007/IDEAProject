package JAVASocket.TCP;

import java.io.*;
import java.net.Socket;

/**
 * 服务器段线程处理类
 */
public class ServerThread extends Thread {
    //每一个客户端都对应了一个和本线程相关的Socket
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //3.获取字节输入流，获取客户端发来的信息
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说" + info);
            }
            //关闭输入流
            socket.shutdownInput();
            //4.获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎你~");
            pw.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            try {
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
