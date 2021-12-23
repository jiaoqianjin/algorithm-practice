package interview.daoyu;

/**
 * Description：
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands which the sum of 1‘s on the island equal S (S>0).
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 *  ["1","1","1","1","0"],
 *  ["1","1","0","1","0"],
 *  ["1","1","0","0","0"],
 *  ["0","0","0","0","0"]
 * ], S = 9
 * Output: 1
 *
 * @author jiaoqianjin
 * Date: 2021/12/17 19:57
 **/

public class SumIsland {
    /*
     * 功能描述: 计算S面积大小的岛屿数量
    */
    public int sumIslands(char[][] grid, int S) {
        int res = 0;
        // 遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    int temp = dfs(grid, i, j);
                    if (temp == S) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    /**
     *功能描述: dfs遍历，计算每个岛屿的面积
    */
    private int dfs(char[][] grid, int r, int c) {
        // 结束条件，出边界
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }
        // 不是岛屿，返回
        if (grid[r][c] != '1') {
            return 0;
        }
        // 标记走过的岛屿,防止重复
        grid[r][c] = 2;

        // 遍历四个方向
        return 1 + dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    // 测试
    public void sumIslandsTest() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        int S = 9;
        // test implementation
        System.out.println(sumIslands(grid, S));
    }

    public static void main(String[] args) {
        SumIsland sumIsland = new SumIsland();
        sumIsland.sumIslandsTest();
    }
}
