package interview.wangfanxin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description：题（二）
 * 给定一个 List<Integer> numList, 他的 size 为 1000，每一个 numList 的元素随机
 * 从 1-100 取值（取值内容为整数），然后将 numList 中的元素从小到大排序，排除掉最大的
 * 10%的元素后；在 numList 剩下的 90%的元素中，取最大值 maxValue 和最小值 minValue，
 * 将区间[minValue,maxValue] 分成 9 个区间（尽量保证每个区间的宽度相等或接近）；在这
 * 9 个区间中，统计 numList 中的元素分别落在每个区间中的个数
 *
 * @author jiaoqianjin
 * Date: 2021/11/4 19:30
 **/

public class Two {
    /**
     * 功能描述: 初始化1000个元素的几个，每个元素是1-100的随机数
     *
     * @return 1000个随机数的集合
     */
    private List<Integer> init() {
        List<Integer> list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            list.add((int) (Math.random() * 100 + 1));
        }
        return list;
    }

    /**
     * 功能描述: 排序并且剔除集合中最大的10%的元素
     *
     * @return 处理好的元素集合
     */
    private List<Integer> prepare() {
        // 初始化1000个随机数集合
        List<Integer> randomList = this.init();
        // 排序
        Collections.sort(randomList);
        // 剔除集合中最大的10%的元素
        return randomList.subList(0, 900);
    }

    /**
     * 功能描述:
     * 分区算法：
     * 1. 理想分区，每个分区100个元素，每次尝试取100个元素（临界下标criticalIndex）
     * 2. 相邻区间，临界值的分配问题
     * ① 同一个数既在左区间，又在右区间怎么分配？
     * ② 统计这个临界值在左区间和右区间出现的次数
     * ③ 左区间出现多，分配在左区间。右区间出现多，这个值分配在右区间
     * 3. 每次分配完成后，计算重要数据如下：
     * ① 记录上一次区间的临界值，方便计算数量
     * ② 计算下一个区间的临界值（默认+100）
     * 4. 处理整个计算的临界值情况
     */
    public void distributeInterval() {
        // 取出90%最大元素的集合
        List<Integer> randomList = this.prepare();
        // 每次分区的临界值
        int criticalValue;
        // 每次分区的临界索引
        int criticalIndex = 99;
        int nextInterval = 0;
        // 分配9个区间
        for (int i = 1; i < 10; i++) {
            criticalValue = randomList.get(criticalIndex);
            // 计算临界值应该放在左区间还是右区间
            int leftCount = 0, rightCount = 0;
            int leftIndex = criticalIndex, rightIndex = criticalIndex;
            // 左区间统计
            while (leftIndex > 0 && criticalValue == randomList.get(leftIndex)) {
                leftIndex--;
                leftCount++;
            }
            // 右区间统计
            while (rightIndex < 900 && criticalValue == randomList.get(rightIndex)) {
                rightIndex++;
                rightCount++;
            }
            // 临界值左边数量多，放左边；右边数量多，放右边
            criticalIndex = leftCount >= rightCount ? rightIndex : leftIndex;
            //当前区间元素数量
            int countInterval = criticalIndex - nextInterval;
            System.out.println("第" + i + "个区间中元素的个数为：" + countInterval);
            // 分区计算完后，重置下一次计算的数据
            nextInterval = criticalIndex;
            criticalIndex = criticalIndex + 100 < 900 ? criticalIndex + 100 : 899;
        }
    }

    public static void main(String[] args) {
        Two test = new Two();
        test.distributeInterval();
    }
}
