package book.link;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/8/4 15:36
 **/

public class LinkedList {

    /**
     * 功能描述: 初始化链表
     *
     * @author jiaoqianjin
     * @date 2021/8/4
     */
    class Link {
        public int data;
        public Link next;

        public Link(int data, Link next) {
            this.data = data;
            this.next = next;
        }

        public Link(int data) {
            this(data, null);
        }
    }

    /**
     * 头结点
     */
    private Link first;
    /**
     * 链表中节点数
     */
    private int num;

    public LinkedList() {
        first = new Link(0, null);
        num = 0;
    }

    /**
     * 功能描述: 添加头结点
     *
     * @param value 头结点值
     * @author jiaoqianjin
     * @date 2021/8/4
     */
    public void addFirst(int value) {
        Link newLink = new Link(value);
        newLink.next = first;
        first = newLink;
        num++;
    }

    /**
     * 功能描述: 删除头结点
     *
     * @return book.link.LinkedList.Link
     * @author jiaoqianjin
     * @date 2021/8/4
     */
    public Link deleteFirst() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return null;
        }
        Link temp = first;
        first = first.next;
        num--;
        return temp;
    }

    /**
     * 功能描述: 判断链表是否为空
     *
     * @return boolean
     * @author jiaoqianjin
     * @date 2021/8/4
     */
    private boolean isEmpty() {
        return first == null;
    }

    /**
     * 功能描述: 在指定位置插入节点
     *
     * @param index 位置
     * @param value 节点值
     * @author jiaoqianjin
     * @date 2021/8/4
     */
    public void add(int index, int value) {
        if (index < 0 || index > num) {
            throw new IllegalArgumentException("越界");
        }
        Link prev = first;

        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Link current = new Link(value);
        current.next = prev.next;
        prev.next = current;
        num ++;
    }
    /**
     *功能描述: 获取指定位置的节点数据
     * @param index 位置
     * @return int 节点数据
     * @author jiaoqianjin
     * @date 2021/8/4
    */
    public int get(int index) {
        if (index < 0 || index > num) {
            throw new IllegalArgumentException("越界");
        }
        Link link = first.next;
        for (int i = 0; i < index; i++) {
            link = link.next;
        }
        return link.data;
    }


}
