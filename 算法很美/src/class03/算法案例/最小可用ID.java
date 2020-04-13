package class03.算法案例;

import java.util.Arrays;

/**
 * @Auther:焦前进
 * @Data:2020/3/20
 * @Description:
 */
public class 最小可用ID {
    /**
     * 方法一，扫描数组，查看数组中是否存在该数字，O(N^2)
     */
//    public static void find1(int[] arr){
//        int i = 1;
//        while (true){
//            if (Util.indexOf(arr,i) == -1){
//
//            }
//        }
//    }
    /**
     * 方法二，排序，然后扫描数组，看谁不在其位，O(NlogN)
     */
    public static int find2(int[] arr){
        Arrays.sort(arr);
        int i = 0;
        //扫描数组，返回不在其位的数
        for(i = 0 ;i < arr.length; i++){
            if(arr[i] != i+1){ //不在位的最小自然数
                return i + 1;
            }
        }
        return  i + 1;
    }

    /**
     * 改进1：
     * 新建长度为n+1 的数组helper,初始值为0，
     * 扫描原数组中的元素，数值对应helper数组中的下标被记录
     * 最后扫描helper,没有被记录的位置则为所求
     * 空间复杂度 O(N)
     * @param arr
     */
    public static int find3(int[] arr){
        int n = arr.length;
        int[] helper = new int[n+1]; //舍弃下标为0 的位置
        //扫描原数组数字，在helper数组中记录，是几，填在那一位
        for(int i = 0; i < n;i++){
            if(arr[i] < n +1){
                helper[arr[i]] = 1;
            }
        }
        //扫描helper,那个位置没有被记录，则为所求Id
        for(int i = 1 ; i <=n ; i++){
            if(helper[i] == 0){
                return i;
            }
        }
        return n + 1;
    }

    /**
     * 优化2，递归分治
     * @param arr
     */
    public static int find4(int[] arr,int l,int r){
        if(l > r){
            return l + 1;
        }
        int midIndex = l + ((r - l) >> 1);//中间下标
        int q = 第K个元素.selectK(arr,l,r,midIndex - l + 1);//实际在中间的值
//        int q = arr[midIndex];
        int t = midIndex + 1;//期望值
        if(q == t){//左侧紧密
            return find4(arr,midIndex + 1,r);
        }else{//左侧稀疏
            return find4(arr,l,midIndex - 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,3,5,6};
        System.out.println(find2(arr));
        System.out.println(find3(arr));
        System.out.println(find4(arr,0,arr.length-1));
    }
}
