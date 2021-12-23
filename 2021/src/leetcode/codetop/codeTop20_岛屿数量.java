package leetcode.codetop;

/**
 * Description：岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/12/12 13:41
 **/

public class codeTop20_岛屿数量 {
    /**
     * 功能描述: 解题思路：
     * 岛屿数量的计算，上下左右没有相邻的 1 ，则代表为一个单独的岛屿
     *
     * @param grid
     * @return int
     * @author jiaoqianjin
     * @date 2021/12/12
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    // 网格DFS遍历
    private void dfs(char[][] grid, int r, int c) {
        // 结束条件，坐标超出网格范围，则直接返回
        if (!isArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        // 将格子标记为已遍历过
        grid[r][c] = '2';
        // 访问上下左右四个节点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标是否在网格范围内
    private boolean isArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public static void main(String[] args) {
        codeTop20_岛屿数量 test = new codeTop20_岛屿数量();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        test.numIslands(grid);
    }
}
