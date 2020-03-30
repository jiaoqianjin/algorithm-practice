package class03;

/**
 * @Author 焦前进
 * @Date: 2020/3/26 17:46
 * @Description:
 **/

import java.util.ArrayList;

/**
 * 基数排序<br />
 *
 * 思路：是一种特殊的桶排序<br />
 *      初始化0-9号十个桶，<br>
 *      一、按个位数字，将关键字入桶，入完后，依次遍历10个桶，按检出顺序回填到数组中，如<br />
 *      321 322 331  500 423 476 926<br>
 *      0:500
 *      1:321 331
 *      2:322
 *      3:423
 *      4:无
 *      5:无
 *      6:476 926<br>
 *      检出后数组序列为： 500 321 331 423 476 926，然后取十位数字重复过程一，得到<br>
 *      0:500
 *      1:无
 *      2:321 423 926
 *      3:331
 *      4:无
 *      5:无
 *      7:476 <br>
 *      检出后数组序列为： 500 321 423 926 331 476，然后取百位数字重复过程一，得到<br>
 *      0:无
 *      1:无
 *      2:无
 *      3:321 331
 *      4:423 476
 *      5:500
 *      9:926 <br>
 *      检出后数组序列为： 321 331 423 476 500 926，已然有序<br>
 *        但是我们应该继续入桶，不过因为再高位全部是0了，这些元素会按顺序全部进入0号桶，这时0号桶的size==数组的size，这时结束标志<br>
 *      最后再回填到数组，数组就是升序排列的了<br />
 *
 * 时间复杂度： 假设最大的数有k位，就要进行k次入桶和回填，每次入桶和回填是线性的，所以整体复杂度为kN,
 * 其中k为最大数的10进制位数<br />
 * 空间复杂度：桶是10个，10个桶里面存n个元素，这些空间都是额外开辟的，所以额外的空间是N+k，k是进制<br />
 * 肯定是非原址的了<br />
 * 稳定性：假设有相等的元素，它们会次第入桶，次第回数组，不会交叉，所以是稳定的<br />
 *
 * @author zhengwei lastmodified 2017年3月14日
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class 基数排序 {
    // 10个桶，每个桶装的数个数不定，适合用数组加ArrayList
    private static ArrayList[] bucket = new ArrayList[10];
    // 初始化桶
    static {
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList();
        }
    }
    /**
     *
     * @param arr
     * @param d
     *          位数
     */
    public static void sort(int[] arr, int d) {
        for (int i = 0; i < arr.length; i++) {
            switch (getDigitOn(arr[i], d)) {
                case 0:
                    bucket[0].add(arr[i]);
                    break;
                case 1:
                    bucket[1].add(arr[i]);
                    break;
                case 2:
                    bucket[2].add(arr[i]);
                    break;
                case 3:
                    bucket[3].add(arr[i]);
                    break;
                case 4:
                    bucket[4].add(arr[i]);
                    break;
                case 5:
                    bucket[5].add(arr[i]);
                    break;
                case 6:
                    bucket[6].add(arr[i]);
                    break;
                case 7:
                    bucket[7].add(arr[i]);
                    break;
                case 8:
                    bucket[8].add(arr[i]);
                    break;
                default:
                    bucket[9].add(arr[i]);
                    break;
            }
        }
        if (bucket[0].size() == arr.length) { // 全部入桶0，说明不用再排了
            clearAll();
            throw new RuntimeException("结束");
        }
        int k = 0;
        for (int j = 0; j < bucket.length; j++) {// 每个桶
            for (Object m : bucket[j]) { // 每个桶中的元素依次压入原数组
                arr[k++] = (Integer) m;
            }
        }
        // 记得清空
        clearAll();
    }
    private static void clearAll() {
        for (ArrayList b : bucket) {
            b.clear();
        }
    }
    /**
     * 获取数字src在d位上的数值
     *
     * @param src
     * @param d
     * @return
     */
    public static int  getDigitOn(int src, int d) {
        return src / (int) (Math.pow(10, d - 1)) % 10;
    }
    public static void sort(int[] arr) {
        int d = 1;
        while (true) {
            try {
                sort(arr, d++);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
