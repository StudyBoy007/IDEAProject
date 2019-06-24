package JAVAThree.JAVACollection.bean;

import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private Set<Course> Course;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.Course = new HashSet<Course>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourse() {
        return Course;
    }

    public void setCourse(Set<Course> course) {
        Course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
