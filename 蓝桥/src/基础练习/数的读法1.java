package 基础练习;

/**
 * Description：
 *
 * @author jiaoqianjin
 * Date: 2020/4/23 17:02
 **/

import java.util.Scanner;

public class 数的读法1 {
    static String[] du = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    static String deal(String s){//处理非法读法
        s=s.replace("ling wan", "wan");
        s=s.replace("ling bai", "ling");
        s=s.replace("ling shi", "ling");
        s=s.replace("ling ling", "ling");
        if(s.endsWith(" ling")) //末尾的零不读
            s=s.substring(0,s.length()-5);
        if(s.startsWith("yi shi")) //开头的10不读做“一十”而读作“十”
            s = s.replace("yi shi", "shi");
        if(s.endsWith("  wan ")) //避免出现1，0000，0000被读成“yi yi  wan ”;
            s = s.replace("  wan ", "");
        return s;
    }
    static String[] split(String s){//将一串数字从后往前分为若干个四位数，如123456789会被分成：1  2345   6789
        int t = (int)Math.ceil((double)s.length()/4);
        String[] res = new String [t];
        for(int i=t-1;i>0;i--){
            res[i]= s.substring(s.length()-4,s.length());
            s=s.substring(0,s.length()-4);
        }
        res[0] = s;
        return res;
    }
    static String f1(String s){//把一个四位数读出来
        String fristZero="";
        while(s.startsWith("0")){  //如果最开头是零
            s=s.substring(1,s.length());
            fristZero="ling ";
        }
        String res="";
        if(s.length()==1)
            res = fristZero + du[s.charAt(0)-48];
        else if (s.length()==2)
            res = fristZero + du[s.charAt(0)-48]+" shi "+du[s.charAt(1)-48];
        else if (s.length()==3)
            res = fristZero + du[s.charAt(0)-48]+" bai "+du[s.charAt(1)-48]+" shi "+du[s.charAt(2)-48];
        else if (s.length()==4)
            res = fristZero + du[s.charAt(0)-48]+" qian "+du[s.charAt(1)-48]+" bai "+du[s.charAt(2)-48]+" shi "+du[s.charAt(3)-48];
        return deal(res);
    }
    static String f2(String[] s){ //把一串数字读出来
        if(s.length == 1)
            return f1(s[0]);
        else if(s.length == 2)
            return f1(s[0]) + " wan " + f1(s[1]);
        else if(s.length == 3)
            return f1(s[0]) + " yi " + f1(s[1]) + " wan " + f1(s[2]);
        return "error!";
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = f2(split(s));
        System.out.println(deal(res)); //最后把非法的读法都处理掉
    }
}

