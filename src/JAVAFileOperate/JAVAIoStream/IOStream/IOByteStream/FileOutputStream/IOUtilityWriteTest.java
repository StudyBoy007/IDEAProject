package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileOutputStream;

import java.io.File;
import java.io.IOException;

public class IOUtilityWriteTest {
    public static void main(String[] args) {
        try {
            System.out.println("********writeFile********");
            IOUtilityWrite.writeFile("demo\\out.dat");
            System.out.println("********copyFile********");
            IOUtilityWrite.copyFile(new File("demo/test"), new File("demo\\copytest.dat"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
