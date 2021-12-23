package book.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 10:30
 **/

public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        new Thread(()->{
            System.out.println(1);
            count.countDown();
        }).start();
        new Thread(()->{
            System.out.println(2);
            count.countDown();
        }).start();
        new Thread(()->{
            System.out.println(3);
            count.countDown();
        }).start();
        count.await();
        System.out.println(4);
    }
}
