import java.lang.reflect.Array;
import java.util.Arrays;

public class Test23 {
    public static void main(String[] args) {
//        String str=",a,s,,d,3,5,g,a,,,";
//        String[]arr1=str.split(",");
//        System.out.println(Arrays.toString((arr1)));
//        System.out.println("数组的长度为："+arr1.length);
//        System.out.println("******************************************");
//        String[]arr2=str.split(",",0); //结果和上面没有limit参数的结果是一样的，所以说明如果没有给limit赋值，默认为0
//        System.out.println(Arrays.toString((arr2)));
//        System.out.println("数组的长度为："+arr2.length);
//        System.out.println("******************************************");
//        String[]arr3=str.split(",",-1);
//        System.out.println(Arrays.toString((arr3)));
//        System.out.println("数组的长度为："+arr3.length);
//        System.out.println("******************************************");
        String str2="6444446333336222226";
        String[]myarr=str2.split("6");
        System.out.println(Arrays.toString(myarr));
        System.out.println("数组的长度为："+myarr.length);
        System.out.println("******************************************");
        String[]myarr2=str2.split("6",2);
        System.out.println(Arrays.toString(myarr2));
        System.out.println("数组的长度为："+myarr2.length);
        System.out.println("******************************************");
        String[]myarr3=str2.split("6",5);
        System.out.println(Arrays.toString(myarr3));
        System.out.println("数组的长度为："+myarr3.length);

    }
}
