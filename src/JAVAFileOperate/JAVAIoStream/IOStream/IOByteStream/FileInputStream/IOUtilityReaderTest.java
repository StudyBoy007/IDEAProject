package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.FileInputStream;

import java.io.IOException;

public class IOUtilityReaderTest {
    public static void main(String[] args) {
        try {
            System.out.println("**********printHex***********");
            IOUtilityReader.printHex("File\\test");
            System.out.println("**********printHexByByte***********");
            IOUtilityReader.printHexByByte("File\\test");
            System.out.println("**********printHexByByteTwo***********");
            IOUtilityReader.printHexByByteTwo("File\\test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
