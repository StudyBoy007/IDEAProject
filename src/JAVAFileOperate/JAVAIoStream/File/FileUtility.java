package JAVAFileOperate.JAVAIoStream.File;

import java.io.File;

public class FileUtility {
    public static int dirnum;
    public static int filenum;

    public static void main(String[] args) {
        listDirectory(new File("F:\\PHP\\phpStudy\\Apache"));
        System.out.println("该文件夹下的文件夹数量为："+dirnum+",文件数目为："+filenum);
    }

    /**
     * 遍历一个目录下的文件，包含该目录下子目录中的文件
     */
    public static void listDirectory(File dir) {

        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在！");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("该" + dir.getName() + "不是目录");
        }
//        String[] filenames = dir.list(); //File.list()返回的是字符串数组
//        for (String string : filenames) {
//            System.out.println(dir+"\\"+string);
//        }
        File[] files = dir.listFiles(); //File.listFiles()返回类型是File类型的数组
        if (!(files == null)) {
            for (File file : files) {
                if (file.isDirectory()) {
                    dirnum++;
                    listDirectory(file);
                } else {
                    filenum++;
                    System.out.println(file);
                }
            }

        }
    }
}
