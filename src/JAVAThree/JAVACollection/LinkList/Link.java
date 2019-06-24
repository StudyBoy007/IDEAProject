package JAVAThree.JAVACollection.LinkList;

import java.util.*;

/**
 * Create by czq
 * time on 2019/6/21  10:24
 */
public class Link {
    public static void main(String[] args) {

//        String[] arr = {"1", "2", "3"};
//
//
//        List<String> list = Arrays.asList(arr);
//
//        List<String> list1 = new ArrayList<>();
//
//        Collections.addAll(list1, arr);
//
//        arr[0] = "342798473985";
//
//
//        System.out.println(list);
//
//        System.out.println(list1);


        LinkedList<Person> link = new LinkedList<>();
        link.addFirst(new Person("李飞", 18));
        link.addLast(new Person("刘梦昊", 22));
        System.out.println(link);
        System.out.println(link.peekFirst().name);
        System.out.println(link.peekLast().name);
        System.out.println(link.size());

//        StringBuilder a = new StringBuilder("123");
//        List<StringBuilder> list = new ArrayList<>();
//        list.add(a);
//        System.out.println(list.get(0));
//        a.delete(0, a.length());
//        a.append("456");
//        System.out.println(list.get(0));
    }
}
