package JAVAFileOperate.JAVAIoStream.SerializtionObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String stuid;
    private String stuname;
    private transient int stuage;  //加上transient的属性就不会进行jvm默认序列化，也可以自己完成这个元素的序列化

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public Student() {
    }

    public Student(String stuid, String stuname, int stuage) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid='" + stuid + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeObject(stuage);  //和下面readobject对应，不一样会报错
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.stuage = (int) s.readObject();
    }
}
