package JAVAThree.JAVAException.BookRent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookRent {
    public static void main(String[] args) {
        Book []books={
                new Book(1, "动物世界"),new Book(2, "一千零一夜"),new Book(3, "斗破苍穹"),new Book(4, "武动乾坤")
        };
        List<Book>lists=new ArrayList<Book>();
        for (Book book : books) {
            lists.add(book);
        }
        Map<String,Book>map=new HashMap<>();
        for (Book book : books) {
            map.put(book.getBookName(), book);
        }
        while(true){
            Scanner input=new Scanner(System.in);//放外面的话右问题
            System.out.println("输入命令:1-按照名称查找图书;2-按照序号查找图书");
            try {
                //System.out.println("输入命令:1-按照名称查找图书;2-按照序号查找图书");
                int orderNumber=input.nextInt();

                if(orderNumber==1){//按照名称查找图书
                    System.out.println("输入图书名称:");
                    String bName=input.next();
                    //	Book aBook=map.get(bName);
                    System.out.println("book:"+map.get(bName).getBookName());

                }

                else if(orderNumber==2){//按照序号查找图书
                    System.out.println("输入图书序号:");
                    int bNumber=input.nextInt();
                    //Book aBook=lists.get(bNumber-1);
                    System.out.println("book:"+lists.get(bNumber-1).getBookName());

                }

                else{
                    System.out.println("命令输入错误！请根据提示输入数字命令");
                    continue;
                }
                break;
            } catch (IndexOutOfBoundsException e) {//数组下标越界
                // TODO: handle exception
                System.out.println("图书不存在！");
            }catch (NullPointerException e) {// map中没有改对象，空指针异常
                // TODO: handle exception
                System.out.println("图书不存在！");
            }catch (InputMismatchException e) { //输入不符合类型异常
                // TODO: handle exception
                //e.printStackTrace();
                System.out.println("命令输入错误！请根据提示输入数字命令2");
                //break;
            }

        }
    }
}

