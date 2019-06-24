package JAVAFileOperate.JAVAIoStream.IOStream.IOCharStream;

import java.io.*;

public class IsrAndOswDemo {
    public static void main(String[] args) {
        copyfileByChar(new File("File\\imooc"),new File("File\\imooccopy02"));
    }

    public static void copyfileByChar(File scrfile,File copyfile){
        try {
            FileInputStream fis=new FileInputStream(scrfile);
            InputStreamReader isr=new InputStreamReader(fis,"gbk");//不写就是默认项目的编码
            FileOutputStream fos=new FileOutputStream(copyfile);
            OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");//不写也是默认为项目的编码格式
            int c;
            while((c=isr.read())!=-1){
               System.out.print((char)c);
                osw.write(c);
                osw.flush();
            }
            osw.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyfileByCharTwo(File srcfile,File copyfile){
       try {
            FileInputStream fis=new FileInputStream(srcfile);
            InputStreamReader isr=new InputStreamReader(fis,"utf-8");//不写就是默认项目的编码
            FileOutputStream fos=new FileOutputStream(copyfile,true);
            OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");//不写也是默认为项目的编码格式
            int c;
//            char[]chars=new char[20*1024];
            while((c=isr.read())!=-1){
                System.out.print((char)c);
//            }
//            while ((c=isr.read(chars, 0, chars.length))!=-1){
//                String str=new String(chars, 0, c);
//                System.out.println(str);
//                //复制文件
//                osw.write(chars, 0, c);
//                osw.flush(); //不写的话拷贝数据就会失败
            }
            osw.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
