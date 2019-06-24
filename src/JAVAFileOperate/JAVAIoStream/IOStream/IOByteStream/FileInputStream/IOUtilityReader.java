package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtilityReader {
    public static void printHex(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        int b;
        int i = 1;
        while ((b = fis.read()) != -1) {
//            if (b <= 0xf) {
//                System.out.print("0");
//            }
//            System.out.print(Integer.toHexString(b & 0xff) + "  ");
            System.out.print(b + "  ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        fis.close(); //关闭输入流
    }


    public static void printHexByByte(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        int j = 1;
        byte[] bytes = new byte[20 * 1024]; //这里开辟的越大，内存资源就要占用更多，所以一般都会适中，不大不小
        int bytesnum = fis.read(bytes, 0, bytes.length); //返回值是读取的直接的数量
        for (int i = 0; i < bytesnum; i++) {
            if ((bytes[i] & 0xff) <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(bytes[i] & 0xff) + "  ");
            if (j++ % 10 == 0) {
                System.out.println();
            }
        }
        fis.close();
    }

    public static void printHexByByteTwo(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        byte[] bytes = new byte[22];
        int bytesnum = 0;
        int j = 1;
        while ((bytesnum = fis.read(bytes, 0, bytes.length)) != -1) {  //这样bytes的容量就算第一次不够，也可以while循环在来
            for (int i = 0; i < bytesnum; i++) {
                if ((bytes[i] & 0xff) <= 0xf) {
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(bytes[i] & 0xff) + "  ");
//                String str=new String(bytes);
//                System.out.println(str);
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        fis.close();
    }

}
