import java.util.Scanner;

public class Test21 {
    public static void main(String[] args) {
        System.out.println(Test21.test());
    }

    public static int test() {
        System.out.println("请输入一个数字");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 0; i < 1; i++) {
            if (a > 3) {
                return a;
            } else {
                return 3;
            }
        }
        return 8; //虽然方法最后加了方法的return, 可是运行的时候执行的两个rtturn要么是if的，要么是else的，return后 后面在return别的值没有作用
    }
}
