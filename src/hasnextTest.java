import java.util.Scanner;

public class hasnextTest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入若干单词，以空格作为分隔");
//        while(!input.hasNext("#")){
//            String str=input.next();
//            System.out.println("单词为："+str);
//        }
        System.out.println("start");
        boolean a=input.hasNext();
        System.out.println("end");
        String str=input.next();
        String str1=input.next();
        String str2=input.next();
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
}
