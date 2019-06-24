import java.util.Scanner;

public class hasnextxxxTest {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        if(input.hasNextInt()){
            System.out.println("输入的是整形");
        }else if(input.hasNextFloat()){
            System.out.println("输入的是浮点型");
        }
    }
}
