import java.sql.Date;
import java.sql.Time;

public class Test20 {
    public static void main(String[] args) {
        Date date = new Date(new java.util.Date().getTime());
        Time time=new Time(new java.util.Date().getTime());
        String registerTime=date.toString()+time.toString();
        System.out.println(registerTime);
    }
}
