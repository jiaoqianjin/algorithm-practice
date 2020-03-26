package class02;

/**
 * @Auther:焦前进
 * @Data:2020/3/10
 * @Description: 递归实现二分查找
 */
public class 二分查找 {
    /*
    递归解法
     */
    private static int binarySearch1(int[] arr,int low,int high,int key){
        if(low < high){
            return  -1;
        }
        int mid = low + ((high - low) >> 1);
        int midVal = arr[mid];
        if(midVal < key){
            return binarySearch1(arr,mid + 1,high,key);

        }else  if (midVal > key){
            return binarySearch1(arr,low,high - 1,key);
        }else{
            return mid; 
        }
    }
}
