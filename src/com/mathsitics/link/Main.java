package com.mathsitics.link;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        //向链表中添加元素
        for(int i =0; i < 5 ; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }
        //向链表索引的第二位添加666
        linkedList.add(2,666);
        System.out.println(linkedList.toString());

        //删除索引为3 的元素
        linkedList.remove(3);
        System.out.println(linkedList.toString());

        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        //向栈链表中添加元素
        for(int i =0;i < 1; i++){
            listStack.push(i);
            System.out.println(listStack.toString());
        }
        //查看栈顶元素
        listStack.pack();
        //取出栈顶元素
        listStack.pop();
        System.out.println(listStack.toString());
    }

    //测试

}
