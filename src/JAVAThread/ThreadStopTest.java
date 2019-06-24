package JAVAThread;

public class ThreadStopTest extends Thread{
    public static void main(String[] args) { //main函数里面是主线程 run方法相对于另外一个线程的执行
        ThreadStopTest test=new ThreadStopTest();
        System.out.println("线程开始");
        test.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行interrupted方法了");
        test.interrupt();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("application ending");

    }

    @Override
    public void run() {
        System.out.println(this.isInterrupted());//this.isInterrupted（是被终端）默认为false（没被中断）
        while (!this.isInterrupted()) {
            System.out.println("我开始执行了！");
            long time=System.currentTimeMillis();
            while (System.currentTimeMillis()-time<1000){  //相对于Thread.sleep(1000)
            }
/*            //在线程中执行休眠后，在使用该线程对象调用interrupt()方法会得到两个结果
            //1.中断状态被清除.执行了sleep()，wait（）的线程在用interrupt()方法中断,那么该线程调用了interrupted（）方法
             的值不是被设置为true（已经清除状态），而是将他的中断状态清除，就不会由默认的false变为true，所以跳不出while循环
            //2.接收到异常*/

//            try {
//                Thread.sleep(1000);//休眠就是阻塞进程
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println(this.isInterrupted());
//            }
        }
        System.out.println("线程停止,interrupt的值为："+this.isInterrupted());
    }
}
