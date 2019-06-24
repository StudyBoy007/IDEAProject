package JAVAThree.JAVADate;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR); //这里的Calendar.year 这些都是Calendar类的静态常量
        int month=c.get(Calendar.MONTH)+1;//月是从0开始的，所以0代表1月，不过要表示出1月的意思，所以我们+1
        int date=c.get(Calendar.DAY_OF_MONTH);
        int hour=c.get(Calendar.HOUR_OF_DAY); //这里的日 和 小时 和其他的有区别，需要记忆
        int minute=c.get(Calendar.MINUTE);
        int second=c.get(Calendar.SECOND);

        System.out.println("现在是"+year+"年"+month+"月"+date+"日"+"\t"+hour+":"+minute+":"+second);


        //Calendar转换为Date类
        Date date1=c.getTime();
        long haomiao=c.getTimeInMillis();
        System.out.println("日期为："+date1);
        System.out.println("毫秒为："+haomiao);


    }
}
