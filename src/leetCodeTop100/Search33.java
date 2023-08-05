package leetCodeTop100;

import com.sun.tools.javadoc.Start;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/comments/
 *
 * @author xmy
 * @date 2023/5/7 9:56 上午
 */
public class Search33 {

    /**
     * 使用二分搜索法来解决
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] > target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    //这个是对的
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //继续细分，target是在前半段递增的还是在后半段递增的
                if (nums[left] <= target && target <= nums[mid]) {
                    //说明是在前半段
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
//        int n = 0;
        int[] nums = {1, 3};
        int n = 3;
        Search33 search = new Search33();
        int ans = search.search2(nums, n);
        System.out.println(ans);
    }


}
