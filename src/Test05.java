import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test05 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String str:list){
            System.out.println(str);
        }
        System.out.println("remove后*********");
        String[]array={"1","3"}; //不再一起也可以
        list.removeAll(Arrays.asList(array));

        for (String str2:list){
            System.out.println(str2);
        }
    }
}
