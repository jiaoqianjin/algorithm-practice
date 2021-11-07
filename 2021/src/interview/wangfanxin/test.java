package interview.wangfanxin;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2021/11/4 9:47
 **/

public class test {
    public static void main(String[] args) {
//        a(6);
        System.out.println(getCount(6));
        System.out.println(6 + 15 + 22 + 23 + 21 + 18 + 15 + 11 + 9 + 5 + 6);
    }

    public static int getCount(int n) {
        int count = 0;
        List<Integer> lineDataList = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                lineDataList.add(1);
            } else if (i == 1) {
                lineDataList.add(2);
                lineDataList.add(0, 2);
            } else {
                List<Integer> temp = new ArrayList<>(lineDataList);
                for (int j = lineDataList.size() - 2 ; j >= 0; j--) {
                    temp.set(j, lineDataList.get(j) + lineDataList.get(j +1));
                }
                temp.add(i + 1);
                temp.add(0, i + 1);
                lineDataList = temp;
            }
        }
        for (Integer integer : lineDataList) {
            count += integer;
        }
        return count;
    }

    private static void a(int h) {
        int w = h + h - 1;
        int[][] b = new int[h][w];

        // 初始化红字
//        for (int j = 0; j < h; j++) {
//            b[j][w / 2 - j] = j + 1;
//            b[j][w / 2 + j] = j + 1;
//        }
        // 计算黑字
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (j == w / 2 - i || j == w / 2 + i) {
                    b[i][j] = i + 1;
                }
                if (j > w / 2 - i && j < w / 2 + i) {
                    b[i][j] = b[i - 1][j - 1] + b[i - 1][j];
                }
            }
        }
        int res = 0;
        // 计算结果
        for (int i = 0; i < w; i++) {
            res += b[h - 1][i];
        }
        Util.printMatrix(b);
        System.out.println(res);
    }
}
