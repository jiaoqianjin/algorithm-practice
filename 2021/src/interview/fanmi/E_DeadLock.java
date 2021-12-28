package interview.fanmi;

/**
 * Description：死锁
 *
 * @author jiaoqianjin
 * Date: 2021/12/25 14:19
 **/

public class E_DeadLock implements Runnable {
    private final int flag;

    public E_DeadLock(int flag) {
        this.flag = flag;
    }

    //声明锁对象
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    @Override
    public void run() {
        if (flag == 0) {
            // 获取锁lock1,等待获取锁lock2
            synchronized (lock1) {
                try {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock1);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + "等待获得锁" + lock2);
                synchronized (lock2) {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock2);
                }
            }
        }
        if (flag == 1) {
            //获取锁lock2,等待获取锁lock1
            synchronized (lock2) {
                try {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock2);
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + "等待获得锁" + lock1);
                synchronized (lock1) {
                    System.out.println("线程：" + Thread.currentThread().getName() + "已获得锁" + lock1);
                }
            }
        }
    }

    public static void main(String[] args) {
        E_DeadLock test1 = new E_DeadLock(0);
        E_DeadLock test2 = new E_DeadLock(1);
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread1.start();
        thread2.start();
    }
}
