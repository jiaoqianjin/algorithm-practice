package 基础练习;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/20 17:06
 **/

import java.util.Scanner;
public class 质因分解
{
    public static void main(String[] args)
    {
        // TODO 自动生成的方法存根
        Scanner in=new Scanner(System.in);
        //用户输入范围
        int n=in.nextInt();
        int m=in.nextInt();
        for(int i=n;i<=m;i++)
        {
            //分解质因数
            Prime(i);
        }
    }
    public static void Prime(int i)
    {
        int num = 2;
        int n = i;
        //标志第一个值
        int first = 1;
        while (num <= n)
        {
            //判断是否还可以被当前数整除
            if (!(i % num == 0))
            {
                //不能再被前一个数整除
                num++;
            }
            else
            {
                //缩小当前倍数
                i /= num;
                //只执行一次
                if (first == 1)
                {
                    first=0;
                    System.out.print(n + "=" + num);
                }
                else
                {
                    //由小到大依次输出
                    System.out.print("*" + num);
                }
            }
        }

        //产生换行
        System.out.println();
    }
}

