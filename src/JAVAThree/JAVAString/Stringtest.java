package JAVAThree.JAVAString;

import java.util.Arrays;

public class Stringtest {
    public static void main(String[] args) {
        String string = new String("   hello worlld");//三个空格
        System.out.println(string.length());
        System.out.println(string.indexOf('l'));
        System.out.println(string.indexOf("lo"));

        System.out.println(string.lastIndexOf('l'));
        System.out.println(string.lastIndexOf("ll"));
        System.out.println(string.indexOf('f'));//没有的话返回-1

        System.out.println(string.substring(2));
        System.out.println(string.substring(2, 4)); //不包括4

        System.out.println(string.trim()); //去除字符串前后多余的空格 ，字符串自己中间的空格不会消除
        System.out.println(string.trim().length());

        System.out.println(string.toUpperCase());
        System.out.println(string.toUpperCase().toLowerCase());

        System.out.println(string.charAt(6));

        String[] array = string.split(" ");
        System.out.println(Arrays.toString(array));
        byte[] bytes = string.getBytes();
        System.out.println(Arrays.toString(bytes));

        String str = "aa|bb|cc";
        String[] arr = str.split("\\|"); //. | *都需要转义
        System.out.println(Arrays.toString(arr));

        String str2 = "a";
        byte[] arr2 = str2.getBytes();
        if(97=='a'){      //字母可以直接和字节对应的数值进行相等比较
            System.out.println("我们是相等的");
        }
        if(98=='b'){
            System.out.println("b对应的字节编号为98");
        }


    }
}
