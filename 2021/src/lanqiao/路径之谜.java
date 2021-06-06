package lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description：
 * 小明冒充X星球的骑士，进入了一个奇怪的城堡。
 * 城堡里边什么都没有，只有方形石头铺成的地面。
 * <p>
 * 假设城堡地面是 n x n 个方格。【如图1.png】所示。
 * <p>
 * 按习俗，骑士要从西北角走到东南角。
 * 可以横向或纵向移动，但不能斜着走，也不能跳跃。
 * 每走到一个新方格，就要向正北方和正西方各射一箭。
 * （城堡的西墙和北墙内各有 n 个靶子）
 * <p>
 * 同一个方格只允许经过一次。但不必做完所有的方格。
 * <p>
 * 如果只给出靶子上箭的数目，你能推断出骑士的行走路线吗？
 * <p>
 * 有时是可以的，比如图1.png中的例子。
 * <p>
 * 本题的要求就是已知箭靶数字，求骑士的行走路径（测试数据保证路径唯一）
 * <p>
 * 输入：
 * 第一行一个整数N(0<N<20)，表示地面有 N x N 个方格
 * 第二行N个整数，空格分开，表示北边的箭靶上的数字（自西向东）
 * 第三行N个整数，空格分开，表示西边的箭靶上的数字（自北向南）
 * <p>
 * 输出：
 * 一行若干个整数，表示骑士路径。
 * <p>
 * 为了方便表示，我们约定每个小格子用一个数字代表，从西北角开始编号: 0,1,2,3…
 * 比如，图1.png中的方块编号为：
 * <p>
 * 0 1 2 3
 * 4 5 6 7
 * 8 9 10 11
 * 12 13 14 15
 * <p>
 * 示例：
 * 用户输入：
 * 4
 * 2 4 3 4
 * 4 3 3 3
 * <p>
 * 程序应该输出：
 * 0 4 5 1 2 3 7 11 10 9 13 14 15
 *
 * @author jiaoqianjin
 * Date: 2021/2/18 16:40
 **/

public class 路径之谜 {
    static int n = 0;
    // 存储结果
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // 表示地面为n*n方格
        n = read.nextInt();
        // 表示是否经过某块石头，0 未经过，1 为经过
        int[][] visvit = new int[n][n];
        // 表示北边箭靶上的数字（自西向东）
        int[] markX = new int[n];
        // 表示西边箭靶上的数字（自北向南）
        int[] markY = new int[n];
        // 上下左右移动方向
        int[][] next = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            markX[i] = read.nextInt();
        }
        for (int i = 0; i < n; i++) {
            markY[i] = read.nextInt();
        }
        // 起点的操作
        markX[0] -= 1;
        markY[0] -= 1;
        visvit[0][0] = 1;
        list.add(0);
        dfs(0, 0, markX, markY, visvit, next);
        read.close();
    }

    static void dfs(int x, int y, int[] markX, int[] markY, int[][] visit, int[][] next) {
        if (x == n - 1 && y == n - 1) {
            for (int i = 0; i < n; i++) {
                if (markX[i] != 0 || markY[i] != 0) {
                    return;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];
            if (!(nextX < 0 || nextY < 0 || nextX >=n || nextY >= n || visit[nextX][nextY] == 1 || markX[nextX] <= 0 || markY[nextY] <= 0)) {
                markX[nextX] -= 1;
                markY[nextY] -= 1;
                visit[nextX][nextY] = 1;
                 list.add(num(nextX, nextY));
                dfs(nextX, nextY, markX, markY, visit, next);
                markX[nextX] += 1;
                markY[nextY] += 1;
                visit[nextX][nextY] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    static int num(int x, int y) {
        return y * n + x;
    }
}
