package leetCodeTop100;

import java.util.Arrays;

/**
 * 31. 输出下一个区间顺序
 *
 * @author xmy
 * @date 2023/5/6 4:23 下午
 */
public class NextPermutation31 {

    public void nextPermutation(int[] nums) {
        int[] arr = {1, 9, 2, 2, 4, 9, 7, 6, 2, 1};
        int[] res = {1, 9, 2, 2, 6, 1, 2, 4, 7, 9};
        //思想: 从后往前找，找到一个更大的排列，然后让这个更大的排列尽可能的小
        if (nums == null || nums.length == 0) {
            return;
        }
        int targetIndex =  -1;
        //获取到对应的要交换的组合
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                targetIndex = i - 1;
                break;
            }
        }

        if(targetIndex < 0) {
            Arrays.sort(nums);
            return;
        }

        int minValueIndex = targetIndex + 1;
        //不需要找最小值，找最小下标就行了
        for(int i = targetIndex + 1; i <= nums.length - 1; i++) {
            if(nums[i] > nums[targetIndex]) {
                minValueIndex = i;
            }
        }
        //交换值
        int temp = nums[targetIndex];
        nums[targetIndex] = nums[minValueIndex];
        nums[minValueIndex] = temp;

        //对targetIndex 后面的开始升序排列
        Arrays.sort(nums, targetIndex + 1, nums.length);
    }

    public static void main(String[] args) {
        NextPermutation31 nextPermutation31 = new NextPermutation31();
        int[] arr = {1, 9, 2, 2, 4, 9, 7, 6, 2, 1};
        int[] res = {1, 9, 2, 2, 6, 1, 2, 4, 7, 9};
        nextPermutation31.nextPermutation(arr);
        Arrays.stream(arr).forEach(i -> {
            System.out.println(i);
        });
    }
}
