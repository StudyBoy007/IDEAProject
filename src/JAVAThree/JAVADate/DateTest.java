package JAVAThree.JAVADate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        //日期转文本
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//因为月和分都是m，所以记住区分大小写，月是大写，分是小写
        String str = sdf.format(date);
        System.out.println(str);
        //文本转日期
        String str2 = "1998年1月14日 1点32分5秒"; //字符串中1月 规范写是01，写1月也没事，个位的秒数也是同理
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh点mm分ss秒"); //这里格式和字符串格式对应
        try {
            Date date1 = df.parse(str2);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
