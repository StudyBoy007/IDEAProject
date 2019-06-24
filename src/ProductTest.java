import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductTest {
    public static List<Product> pros = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("请输入你的操作：\n上架商品：1\n下架商品：2\n退出系统：3");
                int num = input.nextInt();
                switch (num) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        deleteProduct();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("输入有误，请重新输入！！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请输入符合条件的整形的数值！！");
                String str = input.next();
            }
        }
    }

    public static void addProduct() {
        System.out.println("请输入商品的编号：");
        int pid = input.nextInt();
        System.out.println("请输入商品的名称：");
        String name = input.next();
        Product product = new Product(pid, name);
        pros.add(product);
        System.out.println("上架商品后，货架上拥有的商品有：");
        showProduct();
    }

    public static void deleteProduct() {
        System.out.println("目前货架上有的商品为：");
        showProduct();
        Product ps= null;
        while (true) {
            System.out.println("请输入将下架的商品的编号:");
            int pid = input.nextInt();
            int i=0;
            for (Product product : pros) {
                if (product.getPid() == pid) {
                    ps=product;
                    i++;
                }
            }
            if(i==0){
                System.out.println("商品编号不存在，请重新输入！！");
            }else {
                break;
            }
        }
        pros.remove(ps);
        System.out.println("下架后货架的商品还剩：");
        showProduct();
    }

    public static void showProduct() {
        for (Product product : pros) {
            System.out.println(product);
        }
    }
}
