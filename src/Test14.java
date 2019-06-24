import java.util.Arrays;

public class Test14 {
    public static void main(String[] args) {
        String[]strings=new String[6];
        strings[0]="1";
        System.out.println(Arrays.toString(strings));
        String[]strings1=new String[3];
        strings1[0]="2";
        strings1[1]="3";
        strings1[2]="4";
        strings=strings1;
        System.out.println(Arrays.toString(strings));
    }
}
