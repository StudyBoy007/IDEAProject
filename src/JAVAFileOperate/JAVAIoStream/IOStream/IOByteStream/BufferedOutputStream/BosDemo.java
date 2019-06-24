package JAVAFileOperate.JAVAIoStream.IOStream.IOByteStream.BufferedOutputStream;

import java.io.*;

public class BosDemo {
    public static void main(String[] args) {
        try {
            copyFileByBufferedTwo(new File("demo\\copytest.dat"), new File("demo\\copytest01.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByBuffered(File srcfile, File copyfile) throws IOException {
        if (!srcfile.exists()) {
            throw new IllegalArgumentException("文件不存在");
        }
        if (!srcfile.isFile()) {
            throw new IllegalArgumentException("该" + srcfile + "不是文件");
        }
        FileInputStream fis = new FileInputStream(srcfile);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(copyfile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    public static void copyFileByBufferedTwo(File srcfile, File copyfile) throws IOException {
        if (!srcfile.exists()) {
            throw new IllegalArgumentException("文件不存在");
        }
        if (!srcfile.isFile()) {
            throw new IllegalArgumentException("该" + srcfile + "不是文件");
        }
        FileInputStream fis = new FileInputStream(srcfile);
        BufferedInputStream bis = new BufferedInputStream(fis);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyfile));
        byte[] bytes = new byte[20 * 1024];
        int b = bis.read(bytes, 0, bytes.length);
        for (int i = 0; i < b; i++) {
            bos.write(bytes[i] & 0xff);
            bos.flush(); //bufferedouputstream也需要flush，当然close也包含了
        }
        bis.close();
        bos.close();
    }

    public static void copyFileByBufferedThree(File srcfile, File copyfile) throws IOException {
        if (!srcfile.exists()) {
            throw new IllegalArgumentException("文件不存在");
        }
        if (!srcfile.isFile()) {
            throw new IllegalArgumentException("该" + srcfile + "不是文件");
        }
        FileInputStream fis = new FileInputStream(srcfile);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(copyfile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b;
        byte[] bytes = new byte[20 * 1024];
        while ((b = bis.read(bytes, 0, bytes.length)) != -1) {
            bos.write(bytes, 0, b);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

}
