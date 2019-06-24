package JAVAFileOperate.JAVAIoStream.RandomAcessFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.Arrays;

public class RandomAcessFileTest {
    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if (!demo.exists()) {
            demo.mkdir();
        }
        File file = new File(demo, "raf.dat");
        if (!file.exists()) {
            file.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //指针位置
        System.out.println(raf.getFilePointer());

        //写文件.write()方法
        raf.write('A');
        raf.write('B');
        System.out.println(raf.getFilePointer());
        int i = 0xffffffff;
        //.writeInt()的底层
        raf.write((i >>> 24) & 0xff); //标准写法
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        //直接调用writeInt()的底层
        raf.writeInt(i);
        System.out.println(raf.getFilePointer());

        String str = "中";
        byte[] bytes = str.getBytes("utf-8");
        //.write()
        raf.write(bytes);
        System.out.println(raf.getFilePointer());

        System.out.println("*********读操作**********");
        //du读文件.read()方法
        //读文件首先要将pointer指针重新移回文件的头部
        raf.seek(0);

        //一次性将文件中所有的直接存在一个字节数组中
        byte[] bytes1 = new byte[(int) raf.length()];
        raf.read(bytes1);
        System.out.println(Arrays.toString(bytes1));
        String str1=new String(bytes1);
        System.out.println(str1);
        //以16进制输出
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        //关闭对象
        raf.close();

    }
}
