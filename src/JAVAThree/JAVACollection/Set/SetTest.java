package JAVAThree.JAVACollection.Set;

import JAVAThree.JAVACollection.bean.Course;
import JAVAThree.JAVACollection.bean.Student;

import java.util.*;

public class SetTest {
    public List<Course> coursetoSelect;
    private Scanner input;
    private Student student;

    public SetTest() {
        this.coursetoSelect = new ArrayList<>();
        this.input = new Scanner(System.in);
    }

    public void courseAdd() {
        Course cr1 = new Course("1", "数据结构");
        coursetoSelect.add(cr1);
        Course temp = coursetoSelect.get(0);


        Course cr2 = new Course("2", "c语言");

        coursetoSelect.add(0, cr2);
        Course temp2 = coursetoSelect.get(0);


        Course[] courses = {new Course("3", "离散数学"), new Course("4", "汇编语言")};
        coursetoSelect.addAll(Arrays.asList(courses));
        Course temp3 = coursetoSelect.get(2);
        Course temp4 = coursetoSelect.get(3);


        Course[] courses2 = {new Course("5", "高等数学"), new Course("6", "大学英语")};
        coursetoSelect.addAll(2, Arrays.asList(courses2));
        Course temp5 = coursetoSelect.get(2);
        Course temp6 = coursetoSelect.get(3);
    }

    public void getCourse3() {
        System.out.println("有如下课程待选(foreach遍历)：");
        for (Course course : coursetoSelect) {
            System.out.println("课程：" + course.getId() + ":" + course.getName());
        }
    }

    /**
     * list的contains方法
     *
     * @param
     */

    public void testListContains() {
        System.out.println("请输入课程名称：");
        String name = input.next();
        Course course = new Course();
        course.setName(name);
        System.out.println("新创课程：" + course.getName());
        boolean result = coursetoSelect.contains(course);
        System.out.println("备选课程中是否包含该课程：" + result);
    }

    /**
     * containsall
     *
     * @param
     */
    public void testListContainsAll() {
        System.out.println("请输入两门课程名称：");
        System.out.println("第一门名称：");
        String name1 = input.next();
        System.out.println("第二门名称：");
        String name2 = input.next();
        Course course1 = new Course();
        Course course2 = new Course();
        course1.setName(name1);
        course2.setName(name2);
        Course[] courses = {course1, course2};
        System.out.println("新创课程：" + courses[0].getName() + "和" + courses[1].getName());
        boolean result = coursetoSelect.containsAll(Arrays.asList(courses));
        System.out.println("备选课程中是否包含该两门课程：" + result);
    }

    /**
     * 创建学生对象并且选课
     *
     * @param
     */
    public void createStudentAndSelectCourse() {
        System.out.println("请输入学生的ID：");
        String ID = input.next();
        System.out.println("请输入学生的姓名：");
        String name = input.next();
        student = new Student(ID, name);
        System.out.println("欢迎学生：" + student.getName() + "\t" + "来选课!");
        int num=0;
        for (int i = 0; i < 3; ) {
            System.out.println("请输入课程ID:");
            Scanner input = new Scanner(System.in);
            String id = input.next();
            for (Course course : coursetoSelect) {
                if (course.getId().equals(id)) {
                    if (!student.getCourse().contains(course)) {
                        student.getCourse().add(course);
                        System.out.println("选择了课程为：" + course.getId() + ":" + course.getName());
                        i++;
                    }else {
                        System.out.println("该门课重复选择，请重新选择！");
                        break;
                    }
                } else {
                    num++;
                    continue;
                }
            }
            if(num==coursetoSelect.size()){
                System.out.println("该序号课程不存在，请重新选择");
               // num=0;
                continue;
            }
        }
        System.out.println("同学" + student.getName() + "选择了以下课程：");
        for (Course cr : student.getCourse()) {
            System.out.println(cr.getId() + ":" + cr.getName());
        }
    }

    //set得contains方法
    public void testSetContains() {
        System.out.println("请输入学生已选得课程名称：");
        String name = input.next();
        Course course = new Course();
        course.setName(name);
        System.out.println(student.getName() + "已选课程为：" + course.getName());
        boolean result = student.getCourse().contains(course);
        System.out.println("备选课程中是否包含该课程：" + result);
        //通过list集合的indexof方法返回存在该集合中的对象的索引位置
        if (student.getCourse().contains(course)) {
//            Course course1=new Course();
//            course1.setName("101");
            System.out.println("课程" + course.getName() + "的索引位置为：" + coursetoSelect.indexOf(course));
        }
    }

    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.courseAdd();
        st.getCourse3();
        st.createStudentAndSelectCourse();
        st.testSetContains();
    }
}
