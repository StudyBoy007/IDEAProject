package JAVAThread.TongbuYuHuCiTest;


public class Test1 {

    public static void main(String[] args) {
        MyObject object = new MyObject();
        ObjectRunner A = new ObjectRunner("A", object);
        ObjectRunner B = new ObjectRunner("B", object);
        new Thread(A).start();
        new Thread(B).start();
    }

}

class ObjectRunner implements Runnable {
    private String methodName;
    private MyObject object;

    public ObjectRunner(String methodName, MyObject object) {
        this.methodName = methodName;
        this.object = object;
    }

    @Override
    public void run() {
        if (methodName.equals("A")) {
            System.out.println("start call method A");
            object.methodB();
        } else {
            System.out.println("start call method B");
            object.methodB();
        }

    }

}

class MyObject {
    public synchronized void methodA() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("begin method A ThreadName" + threadName);
            Thread.sleep(2000);
            System.out.println("end method A ThreadName" + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("begin method B ThreadName=" + threadName);
            Thread.sleep(2000);
            System.out.println("end method B ThreadName=" + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
