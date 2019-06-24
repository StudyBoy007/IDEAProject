package JAVAFileOperate.JAVAIoStream.IOStream.IOCharStream;

import java.io.*;

public class FileReaderAndFileWrite {
    public static void main(String[] args) {
        try {
            copyfile(new File("File\\imooc"), new File("File\\imooccopy03"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyfile(File srcfile, File copyfile) throws IOException {
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(copyfile, true); //追加内容加true，这种方式不可以指定编码格式
        int b;
        char[] chars = new char[8 * 1024];
        while ((b = fr.read(chars, 0, chars.length)) != -1) {
            fw.write(chars, 0, b);
            fw.flush();
        }
        fw.close();
        fr.close();
    }
}
