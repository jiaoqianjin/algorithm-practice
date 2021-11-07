package book.queue;

/**
 * Description： 链表实现队列
 *
 * @author jiaoqianjin
 * Date: 2021/8/2 21:00
 **/

public class NodeQueue {
    private int size;
    private Node head;
    private Node tail;


    public NodeQueue() {
        size = 0;
        head = null;
        tail = null;
    }

    class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 功能描述: 判断对列是否为空
     *
     * @return boolean 是否为空
     * @author jiaoqianjin
     * @date 2021/8/2
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *功能描述: 向队列添加元素
     * @param value 待添加的元素
     * @author jiaoqianjin
     * @date 2021/8/2
    */
    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    public Object remove() {
        if(size == 0 ){
            new RuntimeException("队列为空");
        }
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return head;
    }

}
