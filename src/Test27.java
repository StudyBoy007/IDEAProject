import java.util.ArrayList;
import java.util.List;

public class Test27 {
    static List<Product> strs = new ArrayList<>();
    public static void main(String[] args) {
        Product pro1=new Product(2019, "馒头");
        Product pro2=new Product(2020, "泡菜");
        strs.add(pro1);
        strs.add(pro2);
        System.out.println("------------删除前-------------");
        for (Product product:strs){
            System.out.println(product);
        }
        for (Product product:strs){
            if(product.getPid()==2020){
                strs.remove(product);
            }
        }
        System.out.println("------------删除后-------------");
        for (Product product:strs){
            System.out.println(product);
        }

    }
}
