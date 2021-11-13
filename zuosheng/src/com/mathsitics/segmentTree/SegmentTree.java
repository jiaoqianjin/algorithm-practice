package com.mathsitics.segmentTree;


/**
 * @Auther:焦前进
 * @Data:2020/2/2
 * @Description:
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merge<E> merge;
     public SegmentTree(E[] arr,Merge<E> merge){
         this.merge = merge;
         data = (E[]) new Object[arr.length];
         for (int i = 0 ; i < arr.length ; i ++) {
             data[i] = arr[i];
         }
         tree = (E[]) new Object[4 * arr.length];
         buildSegmentTree(0,0,data.length-1);
     }

    private void buildSegmentTree(int treeIndex,int l,int r) {
         if(l == r){
              tree[treeIndex] = data[l];
             return;
         }
         int leftTreeIndex = leftChild(treeIndex);
         int rightTreeIndex = rightChild(treeIndex);

         int mid = l + (r - l) / 2;
         buildSegmentTree(leftTreeIndex,l,mid);
         buildSegmentTree(rightTreeIndex , mid + 1 , l);

         tree[treeIndex] = merge.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }

    public int getSize(){
         return data.length;
     }
     public E get(int index){
         if(index < 0 && index > data.length){
             throw new IllegalArgumentException("下标越界");
         }
         return data[index];
     }
     //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index){
         return 2*index + 1;
    }
    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index){
         return 2*index + 2;
    }
    //返回区间（queryL,queryR)的值
    public E query(int queryL,int queryR){
         if(queryL < 0 || queryL >= data.length || queryR < 0 && queryR >= data.length ||queryL > queryR ){
             throw new IllegalArgumentException("Index is Illegal.");
         }
         return  query(0,0,data.length - 1,queryL,queryR);
    }
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l == queryL && r ==queryR){
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1){
            return query(rightTreeIndex,mid+1,r,queryL,queryR);
        }else if(queryR < mid){
            return query(leftTreeIndex,mid,l,queryL,queryR);
        }
        E leftResult = query(leftTreeIndex,l,queryL,queryR,mid);
        E rightResult = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merge.merge(leftResult,rightResult);
    }
}
