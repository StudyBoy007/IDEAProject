import JAVAThree.JAVACollection.bean.Student;

import java.util.HashSet;

/**
 * 只有重写了hashcode和equals两个方法 这样才能保证set集合中不存在相同的元素，因为当只是重写了equals或者hashcode方法的一种时，都会被认为
 * 两个对象不是一样的，那么就会被再次插入，造成重复，hashcode是每个对象根据地址转成的一种编码，具有唯一标识，所以不重写hashcode，每个对象
 * 的hashcode码都是不一样的，那么相同的都会被插入，同理equals也是一样的，object的equals比较的是两个对象的地址，就算你两个对象的参数都一样
 * 但是他们的地址不一样，那么也算不同，还是会被插入，就无法保证set的集合的不可重复性了，故满足该要求，那么对象的实体类中就必须要对equals和
 * hashcode进行重写
 */

public class Test03 {
    public static void main(String[] args) {
        HashSet<Student> hs=new HashSet<Student>();
        hs.add(new Student("1", "小明"));
        hs.add(new Student("2", "小红"));
        hs.add(new Student("1", "小明"));
        for (Student student:hs){
            System.out.println("id:"+student.getId()+"姓名："+student.getName());
        }
    }
}
