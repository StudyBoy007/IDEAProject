/**
 * Create by czq
 * time on 2019/6/23  11:00
 */
public class Test34 {
    public static void main(String[] args) {
        try {
            int num=100/0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}
