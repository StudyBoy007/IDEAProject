import java.util.Scanner;

public class Test29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (!input.hasNext("#")) { //hasNext返回值是boolen，只要缓冲队里面写了东西东西就返回true，
            i++;
            String str = input.next();//next（）方法返回的是缓冲队中的字符串，如果缓冲队里面没有了就要输入
            System.out.println(str);
            String str1 = input.next();
            System.out.println(str1);
            String str2 = input.next();
            System.out.println(str2);
        }
        System.out.println("运行的" + i + "次");
    }
}
