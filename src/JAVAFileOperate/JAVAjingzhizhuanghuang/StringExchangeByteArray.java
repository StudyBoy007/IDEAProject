package JAVAFileOperate.JAVAjingzhizhuanghuang;

import java.util.Arrays;

public class StringExchangeByteArray {
    /*
    int转byte字节数组
     */
    public static byte[] intToByte(int num) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (num >> 0 * 8 & 0xff); //因为一个直接只可以存8位，所以这里的0xff不要也罢
        bytes[1] = (byte) (num >> 1 * 8 & 0xff);
        bytes[2] = (byte) (num >> 2 * 8 & 0xff);
        bytes[3] = (byte) (num >> 3 * 8 & 0xff);
        return bytes;
    }

    /*
    byte字节数组转int
   */
    public static int ByteToInt(byte[] bytes) {
        int a = (bytes[0] & 0xff) << 0 * 8;  //这里的0xff一定要，不然byte[i]取出值，因为int有32位，位数不够jvm会自动补全
        int b = (bytes[1] & 0xff) << 1 * 8;  //使用0xff是为了保证二进制补码的一致性
        int c = (bytes[2] & 0xff) << 2 * 8;
        int d = (bytes[3] & 0xff) << 3 * 8;


        return a + b + c + d;
    }

    public static void main(String[] args) {
        byte[] bytes = StringExchangeByteArray.intToByte(8143);
        System.out.println(Arrays.toString(bytes));
        int num = StringExchangeByteArray.ByteToInt(bytes);
        System.out.println("字节数组转化为的int值为：" + num);
    }
}
