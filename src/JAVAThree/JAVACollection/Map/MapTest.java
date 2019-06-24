package JAVAThree.JAVACollection.Map;

import JAVAThree.JAVACollection.bean.Student;

import java.util.*;

public class MapTest {
    public Map<String, Student> students;
    public Scanner input;

    public MapTest() {
        this.students = new HashMap<>();
        this.input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
//        mt.testRemove();
//        mt.testModify();
        mt.testKeyOrValueContains();
    }

    /**
     * map put方法
     */

    public void testPut() {
        int i = 0;
        while (i < 3) {
            System.out.println("请输入学生ID：");
            String ID = input.next();
            Student student = students.get(ID);
            if (student == null) {
                System.out.println("请输入学生的姓名：");
                String name = input.next();
                Student stu = new Student(ID, name);
                students.put(ID, stu);
                i++;
            } else {
                System.out.println("该ID已经存在!");
                continue;
            }
        }
    }

    /**
     * map集合的遍历
     */

    //keyset方法
    public void testKeySet() {
        Set<String> keyset = students.keySet();//获取所以的key值
        for (String key : keyset) {
            Student student = students.get(key);
            if (student != null) {
                System.out.println("学生：" + student.getName());
            }
        }
    }

    //entrySet
    public void testEntrySet(){
        Set<Map.Entry<String,Student>> entrySet=students.entrySet();
        for (Map.Entry<String,Student> entry:entrySet){
            System.out.println("取得的key值为："+entry.getKey());  //entry对象的getkey方法可以得到这个键值对的key值
            System.out.println("取得的key对应的values的值为："+entry.getValue().getName());//getvalue方法可以得到键值对的value值
        }
    }


    //

    /**
     * map 删除方法
     */
    public void testRemove() {
        System.out.println("请输入要删除学生的ID：");
        String id = input.next();
        Student student = students.get(id);//map也是通过get（key）的方法获取集合中的元素，取得key值映射得到的values值
        while (true) {
            if (student == null) {
                System.out.println("该ID不存在！");
                continue;
            } else {
                students.remove(id);
                System.out.println("成功删除学生："+student.getName());
                break;
            }
        }
        System.out.println("删除学生后的学生还有：");
        testEntrySet();
    }

    /**
     * 修改map中的元素
     * 实际上就是写一个已经存在的key值，去覆盖原来存在的key的映射，通过put方法
     */
    public void testModify(){
        while (true) {
            System.out.println("请输入要修改的学生ID：");
            String id=input.next();
            Student student=students.get(id);
            if(student==null){
                System.out.println("该ID不存在，请重新输入：");
            }else {
                System.out.println("当前ID所对应的学生姓名为："+student.getName());
                System.out.println("请输入新的学生姓名：");
                String name=input.next();
                Student student1=new Student(id, name);
                students.put(id, student1);
                break;
            }
        }
        System.out.println("修改后的学生有：");
        testEntrySet();
    }
    /*
   判断map中是否存在key值，或者value值
     */
    public void testKeyOrValueContains(){
        System.out.println("请输入学生的ID：");
        String ID=input.next();
        //测试map中的containskey()
        System.out.println("该ID是否存在学生集合students中："+students.containsKey(ID));
        if(students.containsKey(ID)){
            System.out.println("该ID对应的学生姓名为"+students.get(ID).getName());
        }
        //测试map中的containvalue()
        System.out.println("请输入学生的姓名：");
        String name=input.next();
        if(students.containsValue(new Student(null, name))){
            System.out.println("该学生集合students中包含学生："+name);
        }else{
            System.out.println("该学生集合students中不包含该姓名的学生");
        }
    }
}