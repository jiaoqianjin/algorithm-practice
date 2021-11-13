package com.mathsitics.link;

public class LinkedListStack<E> implements Stack<E>{
    //实例化链表
    LinkedList<E> list = new LinkedList<>();

    /**
     * 获取链表栈的长度
     * @return
     */
    @Override
    public int getSize() {
        return list.getSize();
    }

    /**
     * 判断链表栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 压入元素
     * @param e
     */
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    /**
     * 从栈顶移出元素
     * @return
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * 取出栈顶元素
     * @return
     */
    @Override
    public E pack() {
        return list.getFirst();
    }
    @Override
    public  String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(list);
        return res.toString();
    }
}
