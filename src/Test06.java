import JAVAThree.JAVACollection.bean.Student;

public class Test06 {
    public static void main(String[] args) {
        Student st1 = new Student("1", "小明");
        Student st2 = new Student("1", "小明");
        if (st1 == st2) {
            System.out.println("我们相等");
        } else {
            System.out.println("我们不相等");
        }
        if (st1.getName() == st2.getName()) {
            System.out.println("我们相等");
        } else {
            System.out.println("我们不相等");
        }
        String str1 = new String("小明");
        String str2 = new String("小明");
        if (str1.equals(str2)) {
            System.out.println("我们相等");
        } else {
            System.out.println("我们不相等");
        }
    }
}
