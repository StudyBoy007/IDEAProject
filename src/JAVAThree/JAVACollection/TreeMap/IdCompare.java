package JAVAThree.JAVACollection.TreeMap;

import java.util.Comparator;

/**
 * Create by czq
 * time on 2019/6/21  16:37
 */
public class IdCompare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.id > o2.id) {
            return 1;
        } else if (o1.id < o2.id) {
            return -1;
        } else {
            return 0;
        }
    }
}
