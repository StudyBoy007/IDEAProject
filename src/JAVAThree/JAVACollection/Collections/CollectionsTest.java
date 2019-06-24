package JAVAThree.JAVACollection.Collections;

import JAVAThree.JAVACollection.bean.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsTest {
    /*
    对学生类进行比较
     */
    public static void compareStudent() {
        List<Student> students=new ArrayList<>();
        students.add(new Student("3", "tom"));
        students.add(new Student("1", "jerry"));
        students.add(new Student("2", "Bob"));
        System.out.println("**************排序前****************");
        for(Student obj:students){
            System.out.println(obj);
        }
        Collections.sort(students);
        System.out.println("**************排序后****************");
        for(Student obj:students){
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        compareStudent();
        List<String> strings = new ArrayList<>();
        String string = "abcdefghyzklmnopqrstuvwxyzABCDEFGHVZKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int stringLength;
            do {
                stringLength = random.nextInt(10);
            } while (stringLength == 0);
            do {
                for (int j = 0; j < stringLength; j++) {
                    int index = (int) (Math.random() * 62);
                    char char1 = string.charAt(index);
                    newString.append(char1);
                }
            } while (strings.contains(newString));
            strings.add(newString.toString());
            newString.delete(0, newString.length());
        }
        System.out.println("*************排序前集合顺序***************");
        for (String str : strings) {
            System.out.println(str);
        }
        Collections.sort(strings);
        System.out.println("*************排序后集合顺序***************");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
