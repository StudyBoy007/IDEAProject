package JAVAThree.JAVACollection.TreeMap;

/**
 * Create by czq
 * time on 2019/6/21  14:22
 */
public class Student {
    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
