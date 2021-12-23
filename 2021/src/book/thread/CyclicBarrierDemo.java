package book.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 10:43
 **/

public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        //1、会议需要三个人
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                //2、这是三个人都到齐之后会执行的代码
                System.out.println("三个人都已到达会议室");
            }
        });
        //3、定义三个线程，相当于三个参会的人
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //4、模拟每人到会议室所需时间
                        Thread.sleep((long) (Math.random() * 5000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("第" + Thread.currentThread().getName() + "个人到达会议室");
                    try {
                        //5、等待其他人到会议室
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "开始开会");
                }
            }, String.valueOf(finalI)).start();
        }
    }
}
