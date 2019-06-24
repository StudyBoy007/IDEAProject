import JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream.IOUtilityReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test08 {
    public static void main(String[] args) {
        if ('A' == 65) {
            System.out.println("我们相等");
        }
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("File\\test02.dat");
            fos.write('A');
            IOUtilityReader.printHex("File\\test02.dat");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
