package JAVAThread.STYYTest;

public class StageThread extends Thread {
    public static void main(String[] args) {
        new StageThread().start();
    }

    @Override
    public void run() {
        ArmyRunnable suiArmy = new ArmyRunnable();
        ArmyRunnable revoltArmy = new ArmyRunnable();
        Thread armyOfSuiDynasty = new Thread(suiArmy, "隋军");
        Thread armyOfRevolt = new Thread(revoltArmy, "农民起义军");
        System.out.println("隋唐演义，百家讲坛现在开始~");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("话说隋唐年间," + armyOfSuiDynasty.getName() + "的队伍和" + armyOfRevolt.getName() + "的队伍杀你热火朝天，难分难解！");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //让双方军队开始厮杀
        System.out.println("战争一触即发~");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //战斗开始
        armyOfRevolt.start();
        armyOfSuiDynasty.start();

        //休眠舞台线程
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread mrChen = new KeyPerson();
        mrChen.setName("程咬金");
        System.out.println("突然前方传来好报，有一位关键英雄" + mrChen.getName() + "前来助阵");

        //让军队停止
        suiArmy.keepRunning = false;
        revoltArmy.keepRunning = false;

        //会让线程突然的终止，嘎然而止，对程序是有害的
//        armyOfRevolt.stop();
//        armyOfSuiDynasty.stop();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        mrChen.start();
        try {
            mrChen.join();//指明该线程运行的时候别的线程不可以运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("因为"+mrChen.getName()+"的及时出现，取得了胜利，从此人民安居乐业，过上了幸福的生活！");
        System.out.println("谢谢观看隋唐演义，再见！");
    }
}

