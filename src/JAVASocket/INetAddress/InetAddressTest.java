package JAVASocket.INetAddress;


import com.sun.beans.editors.ByteEditor;
import com.sun.media.sound.SoftTuning;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            //通过getlocalhost获取inetaddress对象
            InetAddress address=InetAddress.getLocalHost();
            System.out.println("计算机名称为："+address.getHostName());
            System.out.println("计算机地址为："+address.getHostAddress());
            //getAddress()获取ip地址拆分的字节数组
            byte[]bytes=address.getAddress();
            System.out.println(Arrays.toString(bytes));
            //直接输出inetAddress
            System.out.println("直接输出inetAddress:"+address);

            //通过计算机名称或者ip地址字符串返回inetaddress对象
//            InetAddress address1=InetAddress.getByName("10.10.202.99");
            InetAddress address1=InetAddress.getByName("LAPTOP-L0789GOO");
            System.out.println(address1.getHostAddress());

            //通过计算机地址字节数组返回inetaddress对象
            InetAddress address2=InetAddress.getByAddress(bytes);
            System.out.println(address2.getHostAddress());

            //
            InetAddress address3=InetAddress.getByName("localhost");
            System.out.println(address3);



  } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
