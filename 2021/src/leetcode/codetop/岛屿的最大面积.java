package leetcode.codetop;

/**
 * Description：岛屿的最大面积
 * <p>
 * 功能描述:
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿是由一些相邻的1代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * @return
 * @date 2021/12/13
 */

public class 岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前块为1，则开始DFS遍历出相邻的所有1
                if (grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    // 记录最大的岛屿面积
                    res = Math.max(temp, res);
                }

            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 终止条件，越界则终止
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        // 不为1，则终止
        if (grid[i][j] != 1) {
            return 0;
        }
        // 将走过的方格设置2，防止重复遍历
        grid[i][j] = 2;

        return 1
                + dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1);
    }
}
