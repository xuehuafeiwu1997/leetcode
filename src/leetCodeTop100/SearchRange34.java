package leetCodeTop100;

import java.util.Arrays;

/**
 * 34.在排序数组中查找元素的第一个和最后一个位置
 *
 * @author xmy
 * @date 2023/8/5 16:32
 */
public class SearchRange34 {
    public static void main(String[] args) {
        SearchRange34 searchRange34 = new SearchRange34();
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
//        int[] nums = {1};
        int target = 8;
        int[] ints = searchRange34.searchRange2(nums, target);
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }

    //这个思路并不好，直接使用二分查找把第一个和最后一个找出来
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;
        //找寻第一个和最后一个元素
        //注意这里要使用<= 如果不使用等于，那么对于nums数组只有一个元素的情况下，就不会进入循环
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //找到之后，找寻第一个和最后一个
                int leftIndex = mid;
                int rightIndex = mid;
                //找左边界
                while (leftIndex > 0 && nums[leftIndex] == nums[leftIndex - 1]) {
                    leftIndex--;
                }
                while(rightIndex + 1 < nums.length && nums[rightIndex] == nums[rightIndex + 1]) {
                    rightIndex++;
                }
                ans[0] = leftIndex;
                ans[1] = rightIndex;
                return ans;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;
        int first = - 1;
        int last = -1;
        //找寻第一个和最后一个元素
        //注意这里要使用<= 如果不使用等于，那么对于nums数组只有一个元素的情况下，就不会进入循环
        //找左边界
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; //重点
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        left = 0;
        right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; //重点
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{first, last};
    }



}
