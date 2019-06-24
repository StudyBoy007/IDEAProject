package JAVAThree.JAVAMath;

public class MathTest {
    public static void main(String[] args) {
        double a = 3.14;
        long b = Math.round(a);
        System.out.println(b);
        double c = Math.ceil(a);
        System.out.println(c);
        double d = Math.floor(a);
        System.out.println(d);

        MathTest obj=new MathTest();
        obj.test();

           //随机生成[0,99)的数
        double e =  Math.random() * 99; //如果要强转成int int e=(int)(Math.random()*99) ,后面的整体需要加上括号
        System.out.println(e);
    }
    public void test(){
        System.out.println("ni hao");
    }

}
