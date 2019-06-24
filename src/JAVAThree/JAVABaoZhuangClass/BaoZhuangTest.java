package JAVAThree.JAVABaoZhuangClass;

public class BaoZhuangTest {
    public static void main(String[] args) {
        Integer integer=new Integer("688");
        System.out.println(integer);
        String str="900";
        Integer integer1=Integer.valueOf(str);//字符串只可以是数字
        System.out.println(integer1);

        System.out.println("-----将基本数据类型转换为字符串类型-----");
        int a=5;
        String one=Integer.toString(a);
        String two=String.valueOf(a);
        String three=a+"";
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println("-----将字符串类型转换为基本数据类型-----");
        String string="668";
        int first=Integer.valueOf(string);
        int second=Integer.parseInt(string);
        System.out.println(first);
        System.out.println(second);
    }
}
