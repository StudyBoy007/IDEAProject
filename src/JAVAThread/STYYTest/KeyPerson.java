package JAVAThread.STYYTest;

public class KeyPerson extends Thread{
    public static void main(String[] args) {

    }
    @Override
    public void run() {
        System.out.println("半路杀出一个"+getName()+",他是战事的关键先生！");
        for (int i=1;i<10;i++){
            System.out.println(getName()+"发出了"+i+"次攻击！");
        }
        System.out.println("因为"+getName()+"的出现，敌方溃不成军");
    }
}
