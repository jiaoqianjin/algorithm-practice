package com.code.leetCodes;

/**
 * @Auther:焦前进
 * @Data:2020/2/3
 * @Description:
 */
public class fivefiveone {
    public static void main(String[] args) {
      new  fivefiveone();
    }
    fivefiveone(){
        System.out.println(checkRecord("PPllPALLP"));
    }
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
       for (int i = 0 ; i < s.length() ; i++){
           char c = s.charAt(i);
           if(c == 'P'){
               l = 0;
           }else{
               if (c == 'A'){
                   a ++;
                   if(a > 2 ){
                       return false;
                   }
                   l = 0;
               }else if(c == 'L'){
                   l ++;
                   if(l > 2){
                       return false;
                   }
               }
           }
       }
       return true;
    }
}
