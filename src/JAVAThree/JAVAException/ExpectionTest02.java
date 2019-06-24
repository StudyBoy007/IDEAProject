package JAVAThree.JAVAException;
//try catch finally return的记载
/**
 * 总结：1.try catch中有return，return的值在finally中被修改，参数传出去不会改变,参数是公共变量也不会改变
 *      2.try catch finally中都有返回值,不会执行try catch中的返回值，而执行finally中的返回值
 *      3.如果try catch中都有return，那么finally后面就不i会执行，所以再写什么都不会输出，都会报错，当finally中的东西肯定都会输出
 *      4.finally中的东西是在try catch执行完成才执行
 *      5.当try catch两个都没有return时，方法的return会执行，当try catch只有一个有return，那么方法中一定要有return，且会执行
 *      6.mian方法中定义的str2变量，定义的时候没有付值，但在try中附了初值，但是在catch中还是算没有赋初值的，需要在定义时就付初值
 *      7.
 */

import java.util.Scanner;

public class ExpectionTest02 {
    public static void main(String[] args) {
        System.out.println(new ExpectionTest02().test());
    }

    public String test() {
        String str1="";
        String str2="";
        try {
            System.out.println("请输入整数");
            Scanner input=new Scanner(System.in);
            str2="我是catch中的返回值我输出了";
            int a=input.nextInt();
            str1 = "我是try中的返回值";
            return str1;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        } finally {
            str1 = "我是finally中的返回值";
            System.out.println("我是finally我输出了");
        }
//        String str3 = "我是方法的return";
//        return str3;
    }
}
