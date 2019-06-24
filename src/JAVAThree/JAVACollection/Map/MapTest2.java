package JAVAThree.JAVACollection.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by czq
 * time on 2019/6/21  9:28
 */
public class MapTest2 {
    /*
   hashmap中key值为自定义类必须要用重写equals和hashcode，value的类只需要重写equals
     */
    public static void main(String[] args) {
        HashMap<Num, User> testMap = new HashMap<>();
        //hashmap和hashset一样，要重写hashcode和equals方法
        Num num = new Num(1);
        Num num1 = new Num(1);

        testMap.put(num, new User("1", "123"));
        testMap.put(num, new User("2", "321"));//key对象一样，后面key的value覆盖前面key的value
        System.out.println(testMap.containsKey(num1));
        System.out.println(testMap.containsValue(new User("1", "123")));
        System.out.println(testMap.size());
    }
}
