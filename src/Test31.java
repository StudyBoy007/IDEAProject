public class Test31 {
    public int a;

    public static void main(String[] args) {
        int i = 3;
        int sum = (++i) + (i++) + (--i) + (i--) + (i++);
        System.out.println(sum);
    }


}
