package arrayDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static com.sun.tools.doclint.Entity.nu;

/**
 * 微软：数组中第K个最大的元素
 *
 * @author xmy
 * @date 2022/4/30 9:01 下午
 */
public class Solution {
    //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i <= (nums.length - 1) / 2; i ++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        //降序排列之后
        Arrays.asList(nums).forEach( item -> {
            System.out.println(item);
        });
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int result = 0;
        result = findKthLargest(nums, 2);
        System.out.println("当前数组第K个大的元素为" + result);
    }
}
