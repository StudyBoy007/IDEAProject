package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileOutputStream;

import JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream.IOUtilityReader;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * Fileoutputstream的write 写操作
 */
public class IOUtilityWrite {
    public static void writeFile(String filename) throws IOException {
        //如果文件不存在直接创建，如果文件存在就先删除在创建，如果不想删除想追加的内容的话需表明，在后面append属性赋值true
        //下方内容就表示追加的部分
//        FileOutputStream fos = new FileOutputStream(filename, true);
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write('A');
        fos.write('B');
        fos.write('C');
        int a = 10;
        fos.write(a >>> 24);
        fos.write(a >>> 16);
        fos.write(a >>> 8);
        fos.write(a);

        byte[] bytes = "中国".getBytes("utf-8");
        fos.write(bytes);
        fos.close();
        IOUtilityReader.printHex(filename);
    }

    /**
     * 拷贝文件
     */
    public static void copyFile(File srcfile, File copyfile) throws IOException {
        if (!srcfile.exists()) {
            throw new IllegalArgumentException("文件不存在");
        }
        if (!srcfile.isFile()) {
            throw new IllegalArgumentException("该" + srcfile + "不是文件");
        }
        FileInputStream fis = new FileInputStream(srcfile);
        FileOutputStream fos = new FileOutputStream(copyfile);
        byte[] bytes = new byte[20 * 1024];
        int num;
        while ((num = fis.read(bytes, 0, bytes.length)) != -1) {
            fos.write(bytes, 0, num);
            IOUtilityReader.printHex(copyfile.getPath());
            fos.flush();  //字节流不写也没关系 最好加上
        }
        fis.close();
        fos.close();
    }
}
