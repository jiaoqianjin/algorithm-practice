package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description： 51 N皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiaoqianjin
 * Date: 2021/2/6 14:59
 **/

public class N皇后 {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        //初始化数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            // 判断当前位置是否可以放置皇后
//            if (valid(chess, row, col)) {
//                // 如果可以放，我们就把原来的数据chess复制一份
//                char[][] temp = copy(chess);
//                // 然后在这个位置放置皇后
//                temp[row][col] = 'Q';
//                // 下一行
//                solve(res, temp, row + 1);
//            }
            if (valid(chess,row,col)) {
                chess[row][col] = 'Q';
                solve(res,chess,row+1);
                chess[row][col] = '.';
            }
        }
    }

    /**
     * 拷贝数组
     *
     * @param chess 数据源
     * @return 拷贝后的数组
     */
    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }

    /**
     * 判断当前位置是否可以放置皇后
     *
     * @param chess 新数组
     * @param row   行
     * @param col   列
     * @return /
     */
    private boolean valid(char[][] chess, int row, int col) {
        /*
        判断当前列有没有皇后，因为他是一行一行往下走的
        我们只需检查走过的行数即可，通俗一点就是判断当前的坐标位置的上面有没有皇后
         */
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        // 判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // 判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 把数组转为list
     */
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

    public static void main(String[] args) {
        N皇后 n = new N皇后();
        System.out.println(n.solveNQueens(9));
    }
}
