package JAVAFileOperate.JAVAIoStream.File;

import java.io.File;
import java.io.IOException;

/*
file类不可以对file内容进行更改和查看，只可以获取这个文件的一些相关信息，或者创建文件
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("F:\\idea\\workspace\\JAVAPractice\\File");
     //   System.out.println(file.exists());//判断文件是否存在
//        System.out.println(file.isDirectory());//判断是不是目录，不是目录或者不存在都返回false
//        System.out.println(file.isFile());//判断是不是文件
        if(!file.exists()){
            file.mkdir();  //创建目录，.delete()删除，不管是目录还是文件都可以删除
        }                  // .mkdirs 创建多级目录
//        File file1=new File("F:\\idea\\workspace\\JAVAPractice\\File\\test01.txt");
        File file1=new File("F:\\idea\\workspace\\JAVAPractice\\File","test01.txt"); //两种写法
        if(!file1.exists()){
            try {
                file1.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            file1.delete();
        }
        System.out.println(file1);//直接打印文件出现的是文件的路径
        System.out.println(file);
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getParent());//getParentFile放回的类型是File类型，getParent返回的是字符串
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getParentFile().getAbsolutePath());
    }
}
