import java.util.ArrayList;
import java.util.List;

public class Test26 {
    static List<String> strs = new ArrayList<>();
    public static void main(String[] args) {
        String str = "123";
        String str2 = "456";
        strs.add(str);
        strs.add(str2);
        System.out.println("---------------删除前-----------------");
        for (String string:strs){
            System.out.println(string);
        }
        for (String string : strs) {
            if (string == "123") {
                strs.remove(string);
            }
        }
        System.out.println("---------------删除后-----------------");
        for (String string:strs){
            System.out.println(string);
        }
    }
}
