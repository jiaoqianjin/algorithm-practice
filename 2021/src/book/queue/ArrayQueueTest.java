package book.queue;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/8/2 20:29
 **/

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.allDate();
        arrayQueue.remove();
        arrayQueue.allDate();

    }
}
