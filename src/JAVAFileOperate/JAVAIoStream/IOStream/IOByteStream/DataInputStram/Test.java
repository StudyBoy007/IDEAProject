package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.DataInputStram;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("File\\test");
            int b=fis.read();
            System.out.println(Integer.toHexString(b&0xff));
            b=fis.read();
            System.out.println(Integer.toHexString(b&0xff));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
