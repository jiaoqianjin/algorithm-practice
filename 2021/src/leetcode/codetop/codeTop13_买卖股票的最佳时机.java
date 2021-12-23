package leetcode.codetop;

/**
 * Description：买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/11/30 13:30
 **/

public class codeTop13_买卖股票的最佳时机 {
    /**
     * 功能描述: 解题思路
     * 暴力破解，双层for循环，找出最大差值。超出时间限制
     *
     * @param prices 待遍历数组
     * @return int 最大差值
     * @author jiaoqianjin
     * @date 2021/11/30
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int temp = prices[j] - prices[i];
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    /**
     * 功能描述: 解题思路：
     * 记录当前值之前的最小值
     * 遍历数组，计算当前值与前面元素最小值的差值
     * 获取最大的差值
     *
     * @param prices 待遍历数组
     * @return int 最大差值
     * @author jiaoqianjin
     * @date 2021/11/30
     */
    public int maxProfit1(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int price : prices) {
            int temp = price - min;
            res = Math.max(res, temp);
            min = Math.min(min, price);
        }
        return res;
    }

    public static void main(String[] args) {
        codeTop13_买卖股票的最佳时机 test = new codeTop13_买卖股票的最佳时机();
        int[] prices = new int[]{7,1,5,3,6,4};

        System.out.println(test.maxProfit1(prices));
    }
}
