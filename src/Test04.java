import JAVAThree.JAVACollection.bean.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test04 {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        map.put("1", new Student("1", "小明"));
        map.put("2", new Student("2", "小红")); //后来key为1，后来的student对象会把之前的覆盖,value唯一存在
        Student student = map.get("1");
        System.out.println(student.getId() + ":" + student.getName());

        Set<String> set = map.keySet();
        for (String str:set){
            System.out.println(str);
        }
    }
}