package com.basic_class03;

/**
 * @Auther:焦前进
 * @Data:2020/2/16
 * @Description: 用数组结构实现大小固定的栈和队列
 */
public class Array_To_Stack_Queue {
    /**
     *
     * 数组实现栈结构
     */
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;
        //初始化栈
        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }
        //取出栈顶元素
        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[size - 1];
        }
        //向栈中压入元素
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = obj;
        }
        //从栈中取出元素
        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }
    }
    //数组结构实现队列，先进先出
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;
        //初始化队列
        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }
        //取出队首元素
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }
        //向队列中添加元素
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last + 1;
        }
        //取出队列中元素
        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[tmp];
        }
    }

}
