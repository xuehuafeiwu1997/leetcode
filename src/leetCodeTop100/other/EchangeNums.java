package leetCodeTop100.other;

/**
 * 剑指offer21：调整数组顺序，使奇数位于偶数前面
 * 链接：https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * @author xmy
 * @date 2023/5/4 7:30 下午
 */
public class EchangeNums {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
    }


    public int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        //双指针的思路
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            //& 都是1才为1，其余都是0
            //奇数，说明不需要移动，start往后移动
            if((nums[start] & 1)== 1) {
                start++;
            } else if ((nums[end] & 1) == 0) {
                //偶数，不需要移动，end--即可
                end--;
            } else {
                //交换两者的位置
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }
}
