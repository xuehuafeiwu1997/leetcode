package leetCodeTop100;

import java.util.HashMap;

/**
 * leetCode top 100 查询字符串中的最长子串
 *
 * @author xmy
 * @date 2022/6/15 9:59 下午
 */
public class SolutionThird {

    public static void main(String[] args) {
        String s = "abcabcbb";

        int i = lengthOfLongestSubstrings(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    //解法1 没看太明白
//    public static int lengthOfLongestSubstrings(String s) {
//        //记录字符上一次出现的位置
//        int[] last = new int[128];
//        for (int i = 0; i < 128; i++) {
//            last[i] = -1;
//        }
//
//        int n = s.length();
//
//        int res = 0;
//        int start = 0;//窗口开始位置
//        for (int i = 0; i < n; i++) {
//            int index = s.charAt(i);
//            start = Math.max(start, last[index] + 1);
//            res = Math.max(res, i - start + 1);
//            last[index] = i;
//        }
//        return res;
//    }
}
