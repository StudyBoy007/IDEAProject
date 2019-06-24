package JAVAThree.JAVACollection.TreeSet;


import java.util.Random;

/**
 * Create by czq
 * time on 2019/6/21  15:12
 */
public class TreeSet {
    public static void main(String[] args) {
        java.util.TreeSet treeSet = new java.util.TreeSet();
        Student student1 = new Student(1, "蔡泽球");
        Student student2 = new Student(3, "李飞");
        Student student3 = new Student(2, "刘梦昊");
        treeSet.add(student1);
        treeSet.add(student3);
        treeSet.add(student2);
        System.out.println(treeSet);
    }
}
