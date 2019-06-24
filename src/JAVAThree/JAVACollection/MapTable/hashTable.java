package JAVAThree.JAVACollection.MapTable;


import java.util.Hashtable;

/**
 * Create by czq
 * time on 2019/6/24  9:36
 */

/*
hashtable 和hashmap的区别是
1.前者的key和value的值都不能为空
2.前者是线程安全的，后者是线程不安全的（前者的方法前面都有synchronized）
 */
public class hashTable {
    public static void main(String[] args) {
        Hashtable ht=new Hashtable();
        ht.put(1, 1);
        ht.put(2, 2);
        System.out.println(ht.get(1));
    }
}
