package book.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description：实现阻塞队列
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 9:33
 **/

public class BlockQueueDemo {

    static class BlockQueue<T> {
        private Object queue[];
        // 队首指针
        private int front;
        // 队尾指针
        private int rear;
        private int maxSize;

        // 声明ReentrantLock()
        final private Lock lock = new ReentrantLock();
        Condition full = lock.newCondition();
        Condition empty = lock.newCondition();

        // 初始化队列
        public BlockQueue(int maxSize) {
            this.front = 0;
            this.rear = 0;
            this.maxSize = maxSize;
            this.queue = new Object[maxSize];
        }

        /**
         * 功能描述: 阻塞入队，如果队列满则阻塞生产者
         *
         * @param element 待存入元素
         * @author jiaoqianjin
         * @date 2021/11/30
         */
        public void put(T element) {
            lock.lock();
            try {
                // 当队列满的是否，阻塞
                while ((rear + 1) % maxSize == front) {
                    System.out.println("Queue is full");
                    full.await();
                }
                System.out.println("存入：" + element);
                // 将元素存入队列
                queue[rear] = element;
                // 尾指针后移
                rear = (rear + 1) % maxSize;
                // 通知消费者
                empty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 功能描述: 阻塞出队，如果队列空，则阻塞消费者
         *
         * @return 出队元素
         * @author jiaoqianjin
         * @date 2021/11/30
         */
        public T take() throws InterruptedException {
            lock.lock();
            try {
                // 当队列为空的是否，阻塞
                while (rear == front) {
                    System.out.println("Queue is Empty");
                    empty.await();
                }

                Object element = queue[front];
                System.out.println("取出：" + element);
                queue[front] = null;
                front = (front + 1) % maxSize;
                full.signal();
                return (T) element;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        BlockQueue<Integer> blockQueue = new BlockQueue<>(4);
        blockQueue.put(5);
        new Thread(() -> {
            System.out.println("添加");
            blockQueue.put(11);
            blockQueue.put(12);
            blockQueue.put(13);
            blockQueue.put(14);
        }).start();
        new Thread(() -> {
            try {
                System.out.println("取出");
                blockQueue.take();
                Thread.sleep(1);
                blockQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
