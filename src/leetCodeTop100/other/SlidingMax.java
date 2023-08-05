package leetCodeTop100.other;

import java.util.Arrays;

/**
 * 剑指offer59:滑动窗口最大值
 * 链接：https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author xmy
 * @date 2023/4/27 10:09 下午
 */
public class SlidingMax {
    public int[] calSlidingWindowsArr (int[] numbers, int k) {
        //暴力解法,会超时
        int[] ans = new int[numbers.length - k + 1];
        for (int i = 0; i < numbers.length - k + 1; i++) {
            int max = numbers[i];
            for (int j = i + 1; j < i + k && j < numbers.length; j++) {
                max = Math.max(max,numbers[j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    public int[] calSlidingWindowsArr2 (int[] numbers, int k) {
        //暴力解法,会超时
        int[] ans = new int[numbers.length - k + 1];
        for (int i = 0; i < numbers.length - k + 1; i++) {
            int max = numbers[i];
            for (int j = i + 1; j < i + k && j < numbers.length; j++) {
                max = Math.max(max,numbers[j]);
            }
            ans[i] = max;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        SlidingMax slidingMax = new SlidingMax();
        int k = 3;
        int[] ints = slidingMax.calSlidingWindowsArr(nums, 3);
        Arrays.stream(ints).forEach(i -> System.out.println(i));

    }
}
