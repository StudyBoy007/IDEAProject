package JAVAFileOperate.JAVAIoStream.Encode;

import java.io.UnsupportedEncodingException;
/*
1.机器底层都是以2进制去处理运算，默认是以10进制显示给我们看，所以输出一个字节默认是以10进制的值反馈给我们
2.字节为那个编码方式，将字节转为字符串的时候要以相同的编码方式进行转换，否则会乱码
 */

public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String string = "慕课ABC";
        byte[] bytes = string.getBytes(); //什么都不填的话，默认以idea默认的编码方式转换位直接数组
        for (byte obj : bytes) {
            System.out.print(Integer.toHexString(obj & 0xff) + " "); //utf-8的编码中文3个字节，因为1个字节
//            System.out.print((obj & 0xff) + " ");  //默认显示是以10进制输出
        }

        System.out.println();
        //gbk
        byte[] bytes1 = string.getBytes("gbk");//gbk的编码英文2个字节，中文1个字节
        for (byte obj : bytes1) {
            System.out.print(Integer.toHexString(obj & 0xff) + " ");
        }

        //java是双字节编码，编码为utf-16be ，中文和英文都占用2个字节
        System.out.println();
        byte[] bytes3 = string.getBytes("utf-16be");//gbk的编码英文2个字节，中文1个字节
        for (byte obj : bytes3) {
            System.out.print(Integer.toHexString(obj & 0xff) + " ");
        }

        System.out.println();
        String string1 = new String(bytes3);//bytes3为utf-16be的编码，不用对应的编码转换为字符串就换乱码
        System.out.println(string1);

        String string2 = new String(bytes3, "utf-16be");
        System.out.println(string2);

        byte[] bytes2 = "你好".getBytes("ISO-8859-1");
        for (byte obj : bytes2) {
            System.out.println(Integer.toHexString(obj & 0xff) + " ");
        }
        String s = new String(bytes2, "utf-8");
        System.out.println(s);

        /*
        文本文件就是字节序列
        可以是任意编码的字节序列
         */


    }
}
