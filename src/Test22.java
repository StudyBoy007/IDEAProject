public class Test22 {
    public static void main(String[] args) {
        System.out.println("start....");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ending....");
    }
}
