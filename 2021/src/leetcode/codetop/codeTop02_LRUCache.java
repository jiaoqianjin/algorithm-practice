package leetcode.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/11/15 14:03
 **/

public class codeTop02_LRUCache {
    // 初始化双向链表
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 节点数量
    private int size;
    // 缓存大小
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;
    private final Map<Integer, DLinkedNode> cache = new HashMap<>();

    public codeTop02_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 虚拟头，尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 功能描述: 获取指定位置数据的时候，如果为null,则返回-1，
     * 不为null，移动该节点至头结点，并返回该位置value
     *
     * @param key 获取指定位置数据
     * @return int
     * @author jiaoqianjin
     * @date 2021/11/15
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动至该节点至头结点
        moveToHead(node);
        return node.value;
    }

    /**
     * 功能描述: 添加操作
     * 1. 如果添加键不存在，则直接添加到头结点，判断是否超出容量，如果超出容量，则一直最后一个节点
     * 2. 如果键存在，则将该键指向的节点移动至头结点
     *
     * @param key   键
     * @param value 值
     * @author jiaoqianjin
     * @date 2021/11/15
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进hash表
            cache.put(key, newNode);
            // 添加至头结点
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                // 根据尾结点的key从hash表中移出对应元素
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    // 添加头结点
    private void addToHead(DLinkedNode node ) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    // 移出节点
    private void removeNode(DLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    // 移出节点，添加至头结点
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 去除尾结点
    private DLinkedNode removeTail() {
        DLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}
