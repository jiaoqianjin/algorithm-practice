package class03;

import util.Util;

import java.util.Arrays;

/**
 * @Author 焦前进
 * @Date: 2020/3/26 14:48
 * @Description: 计数排序
 * 一句话：用辅助数组对数组中出现的数组计数，元素转下标，下标转元素
 * 假设元素均大于等于0，依次扫描原数组，将元素值k记录在辅助数组的K位上
 * 依次扫描辅助数组，如果为1，将其插入到目标数组的空白处
 * 问题
 *  重复 负数
 *
 * 时间复杂度：扫描一次source,扫描一个helper,复杂度为N+K
 * 空间复杂度：辅助空间k,k=maxOf(source)
 * 非原址排序
 * 稳定性：相同元素不会出现交叉，非原址都是拷来考去
 * 如果要优化一下空间，可以求minOf(source),helper的长度为max-min+1
 * 计数有缺点，数据密集或者范围小时，适用
 *
 **/
public class 计数排序 {
    /**
     * 思路：开辟新的空间，空间大小为max(source)-min(source)+1 <br />
     *        扫描source，将value作为辅助空间的下标，用辅助空间的该位置元素记录value的个数<br />
     *        如：9 7 5 3 1 ，helper=arr(10)<br />
     *        一次扫描，value为9，将helper[9]++，value为7，将helper[7]++……<br />
     *        如此这般之后，我们遍历helper，如果该位（index）的值为0，说明index不曾在source中出现<br />
     *        如果该位（index)的值为1，说明index在source中出现了1次，为2自然是出现了2次<br />
     *        遍历helper就能将source修复为升序排列<br />
     * @param source
     * @return
     */
    public static int[] sort(int[] source){
        //找到目标数组中的最大值
        int max = Util.maxOf(source);
        int min = Util.minOf(source);
        System.out.println(max);
        //创建辅助空间,helper 数组中，指针存的source的值，元素 为值的个数
        int[] helper = new int[max-min+1];
        //将source数组中的值填到helper 数组中
        for(int s : source){
            //解决出现负数的情况
            helper[s - min]++;
        }
        int current = 0;
        //扫描helper 数组，将数组回填
        for(int i = 0; i < helper.length;i++){
            while (helper[i] > 0){
                source[current++] = i + min;
                helper[i] --;
            }
        }
        return source;
    }
//    public static void sort2(int[] source) {
//        int[] helper = new int[util.maxOf(source) + 1];
//        for (int e : source) {
//            helper[e]++;
//        }
//        for (int i = 1; i < helper.length; i++) {
//            helper[i] += helper[i - 1];
//        }
//        int len = source.length;
//        int[] target = new int[len];
//        for (int i = len - 1; i >= 0; i--) {
//            target[helper[source[i]] - 1] = source[i];
//            helper[source[i]]--;
//        }
//        System.arraycopy(target, 0, source, 0, len);
//    }
    public static void main(String[] args) {
        int[] arr = {-1,-2,-5,-2,1,5,9,6,3,4,5};
        System.out.println(Arrays.toString(sort(arr))); //[-5, -2, -2, -1, 1, 3, 4, 5, 5, 6, 9]
//        util.printArray(arr);
//        util.printArray(sort(arr));
//        sort2(arr);
//        util.printArray(arr);
    }
}
