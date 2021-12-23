package book.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 10:34
 **/

public class FutureTaskDemo {
    static class MyCallable1 implements Callable<Integer> {

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + " call()方法执行中...");
            return 1;
        }
    }
    static class MyCallable2 implements Callable<Integer> {

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + " call()方法执行中...");
            return 2;
        }
    }
    static class MyCallable3 implements Callable<Integer> {

        @Override
        public Integer call() {
            System.out.println(Thread.currentThread().getName() + " call()方法执行中...");
            return 3;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask1 = new FutureTask(new MyCallable1());
        new Thread(futureTask1).start();
        System.out.println(futureTask1.get());
        FutureTask futureTask2 = new FutureTask(new MyCallable2());
        new Thread(futureTask2).start();
        System.out.println(futureTask2.get());
        FutureTask futureTask3 = new FutureTask(new MyCallable3());
        new Thread(futureTask3).start();
        System.out.println(futureTask3.get());
        System.out.println(4444444);

    }
}
