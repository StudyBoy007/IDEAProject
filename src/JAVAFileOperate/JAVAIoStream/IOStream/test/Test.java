package JAVAFileOperate.JAVAIoStream.IOStream.test;

import JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream.IOUtilityReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String str="File\\test01.dat";
        try {
            FileOutputStream fos=new FileOutputStream(str);
//            byte[]bytes="中国".getBytes();
//            byte[]bytes=new byte[6];
//            bytes[0]= (byte) 228;
//            bytes[1]= (byte) 184;
//            bytes[2]= (byte) 173;
//            bytes[3]= (byte) 229;
//            bytes[4]= (byte) 155;
//            bytes[5]= (byte) 189;
//            fos.write(bytes);
            fos.write(228);
            fos.write(184);
            fos.write(173);
            fos.write(229);
            fos.write(155);
            fos.write(189);
            IOUtilityReader.printHex(str);

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
