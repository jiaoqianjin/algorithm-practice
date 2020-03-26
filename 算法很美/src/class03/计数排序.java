package class03;

import java.util.Arrays;

/**
 * @Author 焦前进
 * @Date: 2020/3/26 14:48
 * @Description: 计数排序
 * 一句话：用辅助数组对数组中出现的数组计数，元素转下标，下标转元素
 * 假设元素均大于等于0，依次扫描原数组，将元素值k记录在辅助数组的K位上
 * 依次扫描辅助数组，如果为1，将其插入到目标数组的空白处
 *
 * 时间复杂度：扫描一次source,扫描一个helper,复杂度为N+K
 * 空间复杂度：辅助空间k,k=maxOf(source)
 * 非原址排序
 * 稳定性：相同元素不会出现交叉，非原址都是拷来考去
 * 如果要优化一下空间，可以求minOf(source),helper的长度为max-min+1
 * 计数有缺点，数据密集或者范围小时，适用
 **/
public class 计数排序 {
    public static int[] sort(int[] source){
        //找到目标数组中的最大值
        int max = util.maxOf(source);
        //创建辅助空间,helper 数组中，指针存的source的值，元素为值的个数
        int[] helper = new int[max+1];
        //将source数组中的值填到helper 数组中
        for(int e : source){
            helper[e]++;
        }
        int k = 0;
        //扫描helper 数组，将数组回填
        for(int i = 0; i < helper.length;i++){
            while (helper[i] > 0){
                source[k++] = i;
                helper[i] --;
            }
        }
        return source;
    }

    public static void main(String[] args) {
        int[] arr = {1,50,49,68,5,26,44,33};
        util.printArray(arr);
        util.printArray(sort(arr));
    }
}
