package com.mathsitics.link;

public class LinkedList<E> {
    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        //越界处理
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

//                Node node = new Node(e);
//                node.next = prev.next;
//                prev.next = node;

        prev.next = new Node(e, prev.next);

        size++;

    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0, e);
    }

    //在链表末尾添加新的元素e
    public void addList(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index（0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {
        //越界判断
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("获取失败，越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新链表的第index（0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     * @@param e
     */
    public void set(int index, E e) {
        //越界判断
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("获取失败，越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
            cur.e = e;
        }
    }

    //查找链表中是否存在元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表的第index（0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("越界，无法删除");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //从链表中删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素
    public E removeLast() {
        return remove(size);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
