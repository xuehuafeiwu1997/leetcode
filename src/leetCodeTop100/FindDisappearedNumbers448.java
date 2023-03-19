package leetCodeTop100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 448.找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * @author xmy
 * @date 2023/3/19 8:08 下午
 */
public class FindDisappearedNumbers448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //1. 使用额外空间，哈希set的解决办法
        HashSet numSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (numSet.contains(i)) {
                continue;
            } else {
                resultList.add(i);
            }
        }
        return resultList;
    }
}
