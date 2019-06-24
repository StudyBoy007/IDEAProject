package JAVAThree.JAVACollection.TreeSet;

/**
 * Create by czq
 * time on 2019/6/21  14:22
 */
public class Student implements Comparable<Student> {
    public int id;
    public String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
