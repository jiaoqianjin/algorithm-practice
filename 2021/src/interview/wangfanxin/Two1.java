package interview.wangfanxin;

import java.util.*;

/**
 * Description：题（二）
 * 给定一个 List<Integer> numList, 他的 size 为 1000，每一个 numList 的元素随机
 * 从 1-100 取值（取值内容为整数），然后将 numList 中的元素从小到大排序，排除掉最大的
 * 10%的元素后；在 numList 剩下的 90%的元素中，取最大值 maxValue 和最小值 minValue，
 * 将区间[minValue,maxValue] 分成 9 个区间（尽量保证每个区间的宽度相等或接近）；在这
 * 9 个区间中，统计 numList 中的元素分别落在每个区间中的个数
 *
 * @author jiaoqianjin
 * Date: 2021/11/4
 **/

public class Two1 {
    public static void main(String[] args) {
        int length = 1000;
        List<Integer> numList = new ArrayList<>(length);
        Random r = new Random();
        // 初始化集合
        for (int i = 0; i < length; i++) {
            numList.add(r.nextInt(100) + 1);
        }
        // 排序
        Collections.sort(numList);
        // 排除掉最大的10%的元素
        numList = numList.subList(0, 900);
        // 计算分别落在每个区间中的个数
        getCounts(numList);

    }

    /**
     * 功能描述: 计算分别落在每个区间中的个数
     * 该解题思路每次区间临界的元素超出区间范围的个数都会落在前一个区间，
     * 导致前面区间的元素个数超过区间范围，而最后一个区间元素个数不够
     * 暂时还没有更好的集解题思路
     *
     * @param numList 待处理集合
     * @author jiaoqianjin
     * @date 2021/11/4
     */
    public static void getCounts(List<Integer> numList) {
        System.out.println("minValue:" + numList.get(0));
        System.out.println("maxValue:" + numList.get(numList.size() - 1));

        // 区间内元素的值
        int value = numList.get(0);
        int count = 0;
        // 记录区间起始元素
        int section = value;
        for (int i = 1; i < numList.size(); i++) {
            count++;
            if (count >= 100 && numList.get(i) != value) {
                System.out.println("区间" + section + "到" + numList.get(i) + "共" + count + "个数据");
                value = numList.get(i);
                section = value;
                count = 0;
            }
            if (numList.get(i) != value) {
                value = numList.get(i);
            }
        }
        System.out.println("区间" + section + "到" + numList.get(numList.size() - 1) + "共" + count + "个数据");
    }
}
