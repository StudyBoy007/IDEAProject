import JAVAThree.JAVACollection.bean.Course;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("1", "武动乾坤"));
        courses.add(new Course("2", "斗破苍穹"));
        courses.add(new Course("1", "武动乾坤"));
        for (Course courses1 : courses) {
            System.out.println("课程名称：" + courses1.getId() + ":" + courses1.getName());
        }
        Course obj=new Course("1", "武动乾坤");//谁都没删，对象的地址不一样
        courses.remove(obj);
        System.out.println("删除后");
        for (Course courses1 : courses) {
            System.out.println("课程名称：" + courses1.getId() + ":" + courses1.getName());
        }

        System.out.println("***********************************");
        List<String>strings=new ArrayList<>();
        String a=new String("1");
        String b=new String("2");
        String c=new String("1");
        strings.add(a);
        strings.add(b);
        strings.add(c);
        for (String str: strings){
            System.out.println(str);
        }
        strings.remove(strings.get(2));
        System.out.println("remove后");
        for (String str: strings){
            System.out.println(str);
        }

    }
}