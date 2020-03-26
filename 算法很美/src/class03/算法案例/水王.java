package class03.算法案例;

/**
 * @Auther:焦前进
 * @Data:2020/3/20
 * @Description:
 * 找出数组中出现次数正好为数组全部数字一半的数字
 */
public class 水王 {
    /**
     * 找出数组中出现次数正好为数组全部数字一半的数字
     * 水王占总数一半，说明总数必为偶数
     * 不矢一般性，假设一个数就是水王的ID ，两两不同最后一定会消减为0
     * 水王可能是最后一个元素，每次扫描的时候，多一个动作，和最后一个元素做比较，单独计数，计数恰好为N/2
     * 如果不是，计数不为一半，那么去掉最后一个元素，水王就是留下的那个candidate;
     * @param arr
     */
    public static void solve(int[] arr){
        //候选数
        int candidate = arr[0];
        //出现的次数
        int nTimes = 0;
        // 记录最后一个数出现的次数
        int countOfLast = 0;
        int N = arr.length;
        //
        for (int i = 0;i < N ; i++){
            //如果当前数，与最后一个数相同
            if(arr[i] == arr[N-1]){
                countOfLast ++;
            }
            //两两抵消之后，把现在的数作为候选数
            if(nTimes == 0){
                candidate = arr[i];
                nTimes = 1;
                continue;
            }
            // 数字相同，次数加1
            if(arr[i] == candidate){
                nTimes++;
            }else { //数字不同，次数消减
                nTimes--;
            }
        }
        //最后一个元素出现的次数为N/2
        if(countOfLast == N/2){
            System.out.println(arr[N-1]);
        }else {
            System.out.println(candidate);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2};
        solve(arr);
        int[] arr1 = {1,2,3,2};
        solve(arr1);
        int[] arr2 = {2,1,2,3};
        solve(arr2);
        int[] arr3 = {2,2,1,3};
        solve(arr3);
    }
}
