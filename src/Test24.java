import JAVAFileOperate.JAVAIoStream.IOStream.test.Test;

public class Test24 extends Thread {
    public static void main(String[] args) {
        Thread obj = new Test24();
        obj.start();
    }

    @Override
    public void run() {
        System.out.println(getName());
    }
}
