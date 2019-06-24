import java.util.Scanner;

/**
 * Create by czq
 * time on 2019/5/29  15:35
 */
public class Test33 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入日期序号：\n1：周末\n2：工作日");
        String day=input.next();
        System.out.println("请输入天气情况序号：\n1：天气好\n2：天气坏");
        String weather=input.next();
        if (day.equals("周末")){
            if(weather.equals("天气好")){
                System.out.println("我们去海滩");
            }else {
                System.out.println("天气不好，呆在家里");
            }
        }else {
            if(weather.equals("天气好")){
                System.out.println("我们去跑业务");
            }else {
                System.out.println("天气不好，在办公室上网查资料");
            }
        }
    }
}
