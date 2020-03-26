package com.mathsitics.segmentTree;

/**
 * @Auther:焦前进
 * @Data:2020/2/2
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Integer[] num = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(num, new Merge<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        segmentTree.query(3,2) ;
    }
}
