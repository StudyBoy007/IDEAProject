package JAVAThree.JAVACollection.LinkHashMap;

import JAVAThree.JAVACollection.LinkList.Person;

import java.util.*;

/**
 * Create by czq
 * time on 2019/6/24  10:25
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashMap LinkedHashMap = new LinkedHashMap<>();
        LinkedHashMap.put(1, new Person("李飞", 22));
        LinkedHashMap.put(2, new Person("王五", 21));
        LinkedHashMap.put(3, new Person("小刘", 25));
        for (Object o : LinkedHashMap.keySet()) {
            System.out.println(LinkedHashMap.get(o));
        }
        List<Map.Entry<Integer, Person>> list = new ArrayList<>(LinkedHashMap.entrySet());
    }
}
