package class03.算法案例;

import class03.util;

/**
 * @Author 焦前进
 * @Date: 2020/3/28 17:24
 * @Description:
 **/
public class 需要排序的子数组 {
    public static int[] findSegment(int[] A,int n){
        int p1 = -1;
        int p2 = -1;
        int max = A[0];
        int min = A[n - 1];
        //拓展右端点：更新历史最高，只要右侧出现比历史最高低的，就应该将右边界扩展到此处
        for(int i = 0; i < n; i++){
            if(A[i] > max){
                max = A[i];
            }
            //只要低于历史高峰，就要扩展排序区间的右端点
            if(A[i] < max){
                p2 = i;
            }
        }
        //找左端点：更新历史最低，只要左侧出现比历史最低高的，就应该将左边界扩展到此处
        for (int i = n - 1; i >= 0; i--){
            if(A[i] < min){
                min = A[i];
            }
            if(A[i] > min){
                p1 = i;
            }
        }
        if(p1 == -1){
            return new int[]{0,0};
        }
        return new int[]{p1,p2};
    }

    public static void main(String[] args) {
        int[] arr = {2,3,7,4,1,5,6};
        util.printArray(findSegment(arr,arr.length));
    }
}
