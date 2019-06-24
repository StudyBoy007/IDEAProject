package JAVAThree.JAVACollection.TreeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create by czq
 * time on 2019/6/21  16:04
 */
public class MapTree {
    public static void main(String[] args) {
        Student student1 = new Student(1, "蔡泽球");
        Student student2 = new Student(2, "李飞");
        Student student3 = new Student(3, "刘梦昊");
        TreeMap<Student, String> tm = new TreeMap<>(new IdCompare());
        tm.put(student1, "2");
        tm.put(student3, "1");
        tm.put(student2, "3");
        System.out.println(tm);

    }
}