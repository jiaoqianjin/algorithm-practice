package book.queue;

/**
 * Description：数组方式实现队列操作
 *
 * @author jiaoqianjin
 * Date: 2021/8/2 20:08
 **/

public class ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;

    private int MaxSize;

    /**
     * 功能描述: 构造函数
     *
     * @param arrMaxSize 数组最大值
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public ArrayQueue(int arrMaxSize) {
        MaxSize = arrMaxSize;
        arr = new int[MaxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 功能描述: 判断数组是否为空
     *
     * @return boolean 是否为空
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 功能描述: 判断数组是否满了
     *
     * @return boolean 是否满
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public boolean isFull() {
        return (rear + 1) % MaxSize == front;
    }

    /**
     * 功能描述: 给队列添加数据
     *
     * @param n 插入数组中的数据
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public void add(int n) {
        if (isFull()) {
            System.out.println("数组已经满了");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % MaxSize;
    }

    /**
     * 功能描述: 删除队列中元素
     *
     * @return int 返回删除的元素
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public int remove() {
        if (isEmpty()) {
            new RuntimeException("数组为空");
        }
        int a = arr[front];
        front = (front + 1) % MaxSize;
        return a;
    }

    /**
     * 功能描述: 返回队首元素
     *
     * @return int 队首元素
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public int getHeadDate() {
        if (isEmpty()) {
            new RuntimeException("数组为空");
        }
        return arr[front];
    }

    public void allDate() {
        if (isEmpty()) {
            new RuntimeException("数组为空");
        }
        for (int i = front + 1; i < front + size(); i++) {
            System.out.println("arr第" + i + "个元素为：" + arr[i]);
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (MaxSize - front + rear) % MaxSize;
    }
}
