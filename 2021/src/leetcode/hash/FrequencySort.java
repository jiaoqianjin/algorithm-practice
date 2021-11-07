package leetcode.hash;

import java.util.*;

/**
 * Description： 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 451
 *
 * @author jiaoqianjin
 * Date: 2021/7/3 14:07
 **/

public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer num = map.getOrDefault(c, 0) + 1;
            map.put(c, num);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int num = map.get(c);
            for (int j = 0; j < num; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort sort = new FrequencySort();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(sort.frequencySort(str));

    }
}
