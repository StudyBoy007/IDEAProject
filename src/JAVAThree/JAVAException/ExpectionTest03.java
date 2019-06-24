package JAVAThree.JAVAException;

import java.util.InputMismatchException;

//抛出异常
public class ExpectionTest03 {
    public static void main(String[] args) {
        ExpectionTest03 obj = new ExpectionTest03();
        try {
            obj.test(9, 0);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (DrunkException e){
            System.out.println("我是喝多了异常");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void test(int a, int b) throws DrunkException {
        System.out.println("我执行了");
        if (b == 0) {
            throw new DrunkException("被除数不可以为0"); //异常里面写的东西 会给异常的message赋值，当异常被捕获时创建的对象e，可以通过getmessage的方法得到该内容
        } else {
            System.out.println("算术的结果为：" + a / b);
        }
    }
}
