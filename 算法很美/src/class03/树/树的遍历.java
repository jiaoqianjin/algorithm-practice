package class03.树;

import class03.util;

/**
 * @Auther:焦前进
 * @Data:2020/3/24
 * @Description:
 */
public class 树的遍历 {
    /**
     * 树的先序遍历
     * 先输出根节点，再输出左子树，最后输出右子树
     * @param arr
     * @param i
     */
    public static void preOrder(int[] arr,int i){
        if(i >= arr.length){
            return;
        }
        System.out.print(arr[i] + " "); // 先输出根节点
        preOrder(arr,i * 2 + 1); // 再输出左节树
        preOrder(arr,i * 2 + 2); // 输出右节树
    }
    /**
     * 树的中序遍历
     * 先输出左子树，再输出根节点，最后输出右子树
     * @param arr
     * @param i
     */
    public static void inOrder(int[] arr,int i){
        if(i >= arr.length){
            return;
        }
        inOrder(arr,i * 2 + 1); // 输出左节树
        System.out.print(arr[i] + " "); // 输出根节点
        inOrder(arr,i * 2 + 2); // 输出右节树
    }

    public static void main(String[] args) {
        int[] arr = {5,7,8,3,2,1,0};
        util.printArray(arr);
        System.out.println("=====先序遍历结果====");
        preOrder(arr,0);
        System.out.println();
        System.out.println("=====中遍历结果====");
        inOrder(arr,0);
    }
}
