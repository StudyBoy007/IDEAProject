package JAVAFileOperate.JAVAIoStream.RandomAcessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Create by czq
 * time on 2019/6/20  14:48
 */
public class SeekUser {

    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("File\\Hello.txt", "rw");
//            byte[] bytes = new byte[(int) raf.length()];
//            raf.read(bytes);
//            String s = new String(bytes);
//            System.out.println(s);
            byte[] bytes = new byte[3];
            raf.seek(23);
            raf.read(bytes);
            String s = new String(bytes);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
