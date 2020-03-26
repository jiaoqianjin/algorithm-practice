package class01;

/**
 * @Auther:焦前进
 * @Data:2020/3/4
 * @Description:
 * 数组中只有一个数出现1次，其他数都出现K次，请输出只出现了1次的数
 *
 * 分析 2个相同的二进制数做不进位加法，结果为0
 *     10个相同的十进制数做不进位加法，结果为0
 *     k个相同的 k 进制数做不进位加法，结果为0
 *
 * 转换为 k 进制字符数组
 * 不进位加法
 * 最后的结果转换为10 进制
 *
 */
public class 出现K次和出现1次 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,9,7,7,7,3,3,3,6,6,6,0,0,0};
        int len = arr.length;  // 数组的长度
        char[][] kRadix = new char[len][]; //存储转换为K进制的值
        int k = 3;

        //转换为k 进制字符数组
        int maxLen = 0;
        for (int i = 0;i < len;i++) {
            // 将数组中的数转换为K 进制 并进行翻转，使其按照从小到大位 对齐
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;  //获得转换后最长位数的长度
            }
         }
        int [] resArr = new int[maxLen];
        // 每一行进行不进位加法
        for (int i = 0; i < len; i++){
            //不进位加法，每一列
            for (int j = 0 ; j < maxLen; j++){
                // 不超过这一列的长度
                if (j >= kRadix[i].length)
                    resArr[j] += 0;
                else
                    resArr[j] += (kRadix[i][j] - '0'); // 得到每一列 的和
            }
        }
        int res = 0;
        for (int i = 0;i < maxLen; i++){
            res += (resArr[i] % k) * (int)(Math.pow(k,i));  //8%3 20
        }
        System.out.println(res);
    }
}
