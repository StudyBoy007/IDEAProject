public class  Test09 {
    public static void main(String[] args) {
 /*
 1.同级关系的for循环和while循环中定义同一个变量名没事，但如果是嵌套的外层定义了里层在定义相同变量名就会出错
 2.try或者catch中自己定义的变量外面都不可以使用,想但与try catch都是一个独立的方法，里面的局部变量只有自己才可以使用
  */
        while (true){
            while (true){
                int b;
                break;
            }
            for (int i=0;i<10;i++){
                int b=1;
            }
        break;
        }
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                int b;
            }
            while (true){
                int b;
                break;
            }
        }
    }
    public void test(){
        try {
            int i=5;
        }catch (Exception e){
        }
    }
}
