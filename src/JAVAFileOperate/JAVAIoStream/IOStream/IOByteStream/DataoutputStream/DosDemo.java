package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.DataoutputStream;

import JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream.IOUtilityReader;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DosDemo {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\czq\\Desktop\\dos.txt";
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(file,true));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        //采用utf-8编码写出
        dos.writeUTF("中国");
        //采用utf-16be编码写出
        dos.writeChars("中国");
        dos.close();
        IOUtilityReader.printHex(file);
    }
}

