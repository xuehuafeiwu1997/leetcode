package leetCodeTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 15. 三数之和
 *
 * @author xmy
 * @date 2023/4/21 7:49 下午
 */
public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> lists = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //去重，使用HashSet
        HashSet<List<Integer>> hashSet = new HashSet<>();
        //将三数之和转换为两数之和
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == 0) {
                    hashSet.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        //将hashset转换为list
        Iterator<List<Integer>> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
//        //第二种遍历方式
//        for (List<Integer> integerList : hashSet) {
//            result.add(integerList);
//        }
        return result;
    }
}
