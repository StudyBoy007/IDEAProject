package JAVAFileOperate.JAVAIoStream.IOStream.IOCharStream;

import java.io.*;
import java.lang.reflect.Field;

public class BrAndBwOrPwDemo {
    public static void main(String[] args) {
        copyTwo(new File("File\\imooc"), new File("File\\imooccopy04"));
    }

    public static void copy(File srcfile, File copyfile) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcfile)));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(copyfile)));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);//一次读一行，并不能识别换行，这里换行是因为println
                bw.write(line);//写到文件时不具有换行的功能
                //单独写出换行操作
                bw.newLine();
                bw.flush();
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyTwo(File srcfile, File copyfile) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcfile)));
            PrintWriter pw = new PrintWriter("File\\imooccopy04");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pw.println(line); //输出换行
                pw.flush();
            }
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
