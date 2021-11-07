package interview.wangfanxin;

import java.util.Scanner;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/4 12:46
 **/
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //接收输入层数
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("输入度量值需要大于0");
            return;
        }
        System.out.println(getSum(n));
    }

    /**
     * 功能描述: 计算最后一行一层所有数字之和
     *
     * @param n 层数
     * @return int 数字之和
     */
    private static int getSum(int n) {
        // 计算每层实际存储数
        int m = 2 * n - 1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 红字
                if (j == m / 2 - i || j == m / 2 + i) {
                    dp[i][j] = i + 1;
                }
                // 黑字
                if (j > m / 2 - i && j < m / 2 + i) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j + 1];
                }
            }
        }
        int res = 0;
        // 计算结果
        for (int i = 0; i < m; i++) {
            res += dp[n - 1][i];
        }
        return res;
    }
}
