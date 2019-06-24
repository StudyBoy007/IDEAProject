package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.DataInputStram;

import JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream.IOUtilityReader;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DisDemo {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        // TODO Auto-generated method stub
        String file = "demo/dos.dat";
        IOUtilityReader.printHex(file);
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);

        dis.close();
    }
}
