package com.mathsitics.bst;

/**
 * @Auther：焦前进
 * @Data：2019/12/7 16:43
 * @Descripaion:
 */
public class main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums)
            bst.add(num);

        //前序遍历
        bst.preOrder();
        System.out.println();
        //System.out.println(bst);
        //中序遍历
        bst.inOrder();
        System.out.println();
        //后序遍历
        bst.postOrder();
        System.out.println();

        //层序遍历
        bst.leveOrder();
        System.out.println();
        //输出最小元素
        System.out.println( bst.minmum());
        //输出最大元素
        System.out.println( bst.maxmum());
    }
}
