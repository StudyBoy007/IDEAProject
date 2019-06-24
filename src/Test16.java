import java.util.InputMismatchException;
import java.util.Scanner;

public class Test16 {
    public static Scanner input;

    public Test16() {
        this.input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Test16();
        while (true) {
            try {
                System.out.println("********周末事项选择*********");
                System.out.println("1.打游戏\n2.吃东西\n3.看书");
                System.out.println("请选择：");
                int num=input.nextInt();
                System.out.println("你选择了"+num);
                break;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数！");
                String a=input.next();
                System.out.println(a);
            }
        }
    }
}
