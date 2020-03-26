package com.mathsitics.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther：焦前进
 * @Data：2019/12/7 14:56
 * @Descripaion:二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public  E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public  BST(){
        root = null;
        size = 0;
    }

    /**
     * 返回二分搜索树中，元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     * @param e
     */
    public void add(E e){
        //如果没有根节点
        if(root == null){
            root = new Node(e);
            size ++;
        }else
            add(root,e);
    }

    /**
     * 如果根节点已经存在
     * @param node
     * @param e
     */
    private void add(Node node, E e){
        //如果添加的元素等于根节点
        if(e.equals(node.e)){
            return;
        }
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }
        if (e.compareTo(node.e) < 0){
            add(node.left,e);
        }else
            add(node.right,e);
    }

    //改进添加操作
    //public void  add(E e){
    //    root = add(root,e);
    //}
    //private Node add(Node node,E e){
    //    if (node == null){
    //        size ++;
    //        return  new Node(e);
    //    }
    //    //如果节点不为空，需要继续往下遍历，判断往左还是往右之后，将节点返回出来
    //    if (e.compareTo(node.e) < 0){
    //        node.left = add(node.left,e);
    //    }
    //    else if(e.compareTo(node.e) > 0){
    //        node.right = add(node.right,e);
    //    }
    //    return node;
    //}

    /**
     * 判断二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 判断以node为根的二分搜索树中是否包含元素e,递归
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node,E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        else
            return contains(node.right, e);

    }

    //二分搜索的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树
    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //中序遍历以node为根的二分搜素树，递归算法
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    //后序遍历以node为根的二分搜素树，递归算法
    private void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历
    public void leveOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null){
                q.add(cur.left);
            }
            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }

    //寻找二分搜索树中最小的元素
    public E minmum(){
        if(size == 0 ){
            throw new IllegalArgumentException("该树为空");
        }
        return minmum(root).e;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node  minmum(Node node){
        if(node.left == null){
            return node;
        }
        return minmum(node.left);
    }
    //寻找二分搜索 树中最大的元素
    public E maxmum(){
        if(size == 0 ){
            throw new IllegalArgumentException("该树为空");
        }
        return maxmum(root).e;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node  maxmum(Node node){
        if(node.right == null){
            return node;
        }
        return maxmum(node.right);
    }

    //从二分搜索树中删除最小值所在节点，返回最小值
    public  E removeMin(){
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size -- ;
            return rightNode;
        }
        node.left =  removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void  remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分法搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e){
        if(node == null)
            return null;
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else{
            //待删除结点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除结点左右子树均不为空的情况
            //找到比待删除结点大的最小结点，即待删除结点右子树的最小结点
            //用这个结点顶替待删除结点的位置
            Node successor = minmum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }



    public  String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();

    }
}
