package JAVAThree.JAVAException;
//多重异常
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpectionTest {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入第一个数字:");
            int a = input.nextInt();
            System.out.println("请输入第二个数字:");
            int b = input.nextInt();
            int c = a / b;
            System.out.println(a + "与" + b + "运算相除的结果为：" + c);
        } catch (InputMismatchException e) {
            System.out.println("输入的值要为整形");
//            e.printStackTrace(); //打印出错的信息
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
//            System.out.println(e);
        } catch (Exception e) {//把最大的异常放最前面编译器会自己报错
            System.out.println("我是不知名异常，多重异常需要先小在大，大的放后，所以一般来说最后在放一个expection类");
        } finally {
            System.out.println("我是finally，我输出了~");
        }
        System.out.println("我在finally后面，我输出了");
    }
}
