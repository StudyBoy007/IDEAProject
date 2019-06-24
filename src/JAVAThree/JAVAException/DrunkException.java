package JAVAThree.JAVAException;

public class DrunkException extends Exception {
    public DrunkException(String message){
        super(message);
    } //给父类传message参数

    public DrunkException() {
    }
}
