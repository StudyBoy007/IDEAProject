package JAVAThread.STYYTest;

import java.lang.invoke.VolatileCallSite;

public class ArmyRunnable implements Runnable{
    volatile boolean keepRunning=true;
    @Override
    public void run() {
        while (keepRunning){
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻了["+(++i)+"]次！");
                Thread.yield(); //释放当前线程占用处理器的资源
            }
        }
        System.out.println(Thread.currentThread().getName()+"停止了战斗！");
    }
}
