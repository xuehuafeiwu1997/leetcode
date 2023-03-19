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

    //使用摩尔投票法解决
    public static int majorityElement_1(int[] nums) {
        //投票对象
        int candidate = nums[0];
        //票数
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) { //投票对象相同，票数+1
                count++;
            } else { //投票对象不同，票数-1
                count--;
                if (count < 0) { //该元素不是多数元素，更新投票对象
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
