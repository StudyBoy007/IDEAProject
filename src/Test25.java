import java.util.ArrayList;
import java.util.List;

/**
 * 如果在if语句外定义一个变量，没有赋初值，在if语句中给了初值，但是在if语句外还是没有付初值的
 */
public class Test25 {
    public static void main(String[] args) {
        String str = "123";
        String str2="456";
        List<String>strs=new ArrayList<>();
        strs.add(str);
        strs.add(str2);
        String str3=null;
        for (String string:strs){
            if(string=="456"){
                str3=string;
            }
            System.out.println(str3);
        }
        System.out.println(str3);
        String str4=null;
        if(str!=str2){
            str4="nihao";
        }
        System.out.println(str4);
    }
}
