package leetCodeTop100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 [n / 2]的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author xmy
 * @date 2023/3/19 10:11 上午
 */
public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        //使用哈希表来解决
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = numsMap.get(nums[i]);
            count = count == null ? 1 : ++count;
            numsMap.put(nums[i], count);
        }
        for (Integer num : numsMap.keySet()) {
            Integer count = numsMap.get(num);
            if (count > nums.length / 2) {
                return num;
            }
        }
        return -1; //代表未找到
    }
}
