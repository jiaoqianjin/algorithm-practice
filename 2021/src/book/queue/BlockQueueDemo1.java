package book.queue;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 9:59
 **/


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个阻塞队列
 */
public class BlockQueueDemo1 {

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> queue = new BlockQueue<Integer>(4);
        queue.put(5);

        new Thread(() -> {
            try {
                System.out.println("添加");
                queue.put(11);
                queue.put(12);
                queue.put(13);
                queue.put(14);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("取出");
                queue.take();
                Thread.sleep(1);
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    static class BlockQueue<T> {
        private Object queue[];
        private int front;
        private int rear;
        private int maxSize;

        final private Lock lock = new ReentrantLock();
        Condition full = lock.newCondition();
        Condition empty = lock.newCondition();

        public BlockQueue(int maxSize) {
            this.front = 0;
            this.rear = 0;
            this.maxSize = maxSize;
            this.queue = new Object[maxSize];
        }

        /**
         * 阻塞入队
         *
         * @param element
         */
        public void put(T element) throws InterruptedException {
            lock.lock();
            try {
                while ((rear + 1) % maxSize == front) {
                    System.out.println("Queue is full");
                    full.await();
                }
                queue[rear] = element;
                rear = (rear + 1) % maxSize;
                empty.signal();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 阻塞出队
         */
        public T take() throws InterruptedException {
            lock.lock();
            try {
                while (rear == front) {
                    System.out.println("Queue is empty");
                    empty.await();
                }
                Object element = queue[front];
                queue[front] = null;
                front = (front + 1) % maxSize;
                full.signal();
                return (T) element;
            } finally {
                lock.unlock();
            }
        }
    }
}

