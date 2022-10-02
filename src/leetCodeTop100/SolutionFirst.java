package leetCodeTop100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * @author xmy
 * @date 2022/6/13 11:18 下午
 */
public class SolutionFirst {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int target = 5;
        int[] result = twoSum(nums, target);
        for (int i = 0; i < result.length - 1; i++) {
            System.out.println(result[i]);
        }
    }

    //找出所有
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
            }
            //将数据存入  key为补数，value为下标
            hash.put(target - nums[i], i);
        }

        //基本的解法，使用双重循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }
}
