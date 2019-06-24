package JAVAFileOperate.JAVAjingzhizhuanghuang;

public class JZTest {
    public static void main(String[] args) {
        //十进制转为其他进制
        System.out.println("十进制转为其他进制");
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toOctalString(15));
        System.out.println(Integer.toHexString(15));
        //其他进制转化为十进制
        System.out.println("其他进制转化为十进制");
        System.out.println(Integer.valueOf("1f", 16));
        System.out.println(Integer.valueOf("20", 8));
        System.out.println(Integer.valueOf("11111",2));
        //Object obj=Integer.parseInt("1f",16);
    }
}
