package leetCodeTop100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * @author xmy
 * @date 2023/3/19 8:53 上午
 */
public class SingleNumber136 {
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        // 使用java位运算 ^ 异或  相同为0，不同为1
        // 满足交换律、结合律，以及相同数字异或为0，不同数字异或为1，0,与任何数字异或都是那个数字本身
//        int ans = nums[0];
//        if (nums.length > 1) {
//            for (int i = 1; i < nums.length; i++) {
//                ans = ans ^ nums[i];
//            }
//        }
//        return ans;
        //hashMap的解法
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num, count);
        }

        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; //代表未找到
    }
}
