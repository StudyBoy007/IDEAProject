package JAVAThread.STYYTest;

public class Actor extends Thread {
    public static void main(String[] args) {
        Thread actorThread = new Actor();
        actorThread.setName("Mr. Thread");
        actorThread.start();
        Thread actressThread=new Thread(new Actress());
        actressThread.setName("Mrs. Runnable");
        actressThread.start();
    }

    @Override
    public void run() {
        System.out.println(getName() + "是一个演员！");
        int count = 0;
        boolean keeprunning = true;
        while (keeprunning) {

            System.out.println(getName() + "登台演出：" + (++count) + "次！");
            if (count > 99) {
                keeprunning = false;
            }
            if (count%10==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "的演出结束了！");
    }
}

class Actress implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "是一个演员！");
        int count = 0;
        boolean keeprunning = true;
        while (keeprunning) {

            System.out.println(Thread.currentThread().getName() + "登台演出：" + (++count) + "次！");
            if (count > 99) {
                keeprunning = false;
            }
            if (count%10==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "的演出结束了！");
    }
}
