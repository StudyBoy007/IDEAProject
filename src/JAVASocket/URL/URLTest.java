package JAVASocket.URL;

import com.sun.media.sound.SoftTuning;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://www.imooc.com:8080");
            System.out.println("url的主机为："+url.getHost());
            System.out.println("url的协议为："+url.getProtocol());
            URL url1=new URL(url, "/index.html?username=tom#test"); //#锚点 ？参数
            System.out.println("url1的文件为："+url1.getFile());//文件名是文件 加上参数
            System.out.println("url1的锚点为："+url1.getRef());//相对路径就是锚点
            System.out.println("url1的路径为："+url1.getPath());
            System.out.println("url1的协议为："+url1.getProtocol());
            System.out.println("url1的端口为："+url.getPort());
            //如果为自己没有指定端口号，就用协议默认的端口号，但是getport()返回值为-1
            System.out.println("url1的主机名为："+url1.getHost());
            System.out.println("url1查询字符串:"+url1.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
