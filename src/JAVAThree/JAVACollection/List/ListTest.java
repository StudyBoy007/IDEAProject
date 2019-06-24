package JAVAThree.JAVACollection.List;

import JAVAThree.JAVACollection.bean.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*备选课程类*/
public class ListTest {
    //用于存放备选课程的LIST
    public List<Course> coursetoSelect;//没有说明是什么类型的 //规定好了泛型 那么该集合只能存该类型元素或该类型的子类对象

    public ListTest() {
        this.coursetoSelect = new ArrayList();
    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.courseAdd();
        lt.getCourse();
        lt.getCourse2();
        lt.getCourse3();
        lt.modifyCourse();
        lt.getCourse3();
    }

    /**
     * 用于像CoursetoSekkect集合中添加备选课程
     */
    public void courseAdd() {
        Course cr1 = new Course("1", "数据结构");
        //add第一种方法
        coursetoSelect.add(cr1);
        Course temp = coursetoSelect.get(0);
        System.out.println("添加了课程:" + temp.getId() + ":" + temp.getName());

        Course cr2 = new Course("2", "c语言");
        //add第二种方法
        coursetoSelect.add(0, cr2);//index的值不能超过插入前集合的长度，如果集合长度为2，那么index为2就是插入集合末尾，大于2，数组下标越界异常
        Course temp2 = coursetoSelect.get(0);
        System.out.println("添加了课程:" + temp2.getId() + ":" + temp2.getName());

        Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        //add的第三种方法    需要用arrays.aslist方法将数组转为集合 ，这样才可以插入
        coursetoSelect.addAll(Arrays.asList(courses));
        Course temp3 = coursetoSelect.get(2);
        Course temp4 = coursetoSelect.get(3);
        System.out.println("添加了2门课程:" + temp3.getId() + ":" + temp3.getName() + ";" + temp4.getId() + ":" + temp4.getName());

        Course[] courses2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
        //add的第四种方法
        coursetoSelect.addAll(2, Arrays.asList(courses2));
        Course temp5 = coursetoSelect.get(2);
        Course temp6 = coursetoSelect.get(3);
        System.out.println("添加了两门课程:" + temp5.getId() + ":" + temp5.getName() + ";" + temp6.getId() + ":" + temp6.getName());
    }

    //遍历集合种的所以元素

    //for循环
    public void getCourse() {
        System.out.println("有如下课程待选(for循环遍历)：");
        int size = coursetoSelect.size();//和数组不一样，集合长度是用size()方法显示出来
        for (int i = 0; i < size; i++) {
            Course course=coursetoSelect.get(i);
            System.out.println("课程："+course.getId()+":"+course.getName());
        }
    }
    //迭代器
    public void getCourse2(){
        System.out.println("有如下课程待选(迭代器遍历)：");
        Iterator<Course> it=coursetoSelect.iterator(); //迭代器和集合一样，没有事先指明数据类型，都会被强转为object类型
        while (it.hasNext()){                           //迭代器只是用来遍历集合的，本身不能存储数据，是依赖与某个集合存在的
            Course course=it.next();
            System.out.println("课程："+course.getId()+":"+course.getName());
        }
    }

    //foreach
    public void getCourse3(){
        System.out.println("有如下课程待选(foreach遍历)：");
        for(Course course:coursetoSelect){
            System.out.println("课程："+course.getId()+":"+course.getName());
        }
    }

    //修改课程
    public void modifyCourse(){
        coursetoSelect.set(5, new Course("4","编译原理"));
    }
}
