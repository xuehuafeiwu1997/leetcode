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
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers_2 = findDisappearedNumbers_2(nums);
        disappearedNumbers_2.stream()
                .forEach(num -> System.out.println(num));
    }


    //方法1
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

    //方法二: 方法可行，但是超出时间限制
    public List<Integer> findDisappearedNumbers_1(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            resultList.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            resultList.remove((Integer) nums[i]);
        }
        return resultList;
    }
    //方法三：数组下标替换，不需要引入额外的空间
    public static List<Integer> findDisappearedNumbers_2(int[] nums) {
       List<Integer> resultList = new ArrayList<>();
       for (int i = 0; i < nums.length; i++) {
           if (nums[Math.abs(nums[i]) - 1] > 0) {
               nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
           }
       }
       for (int i = 0; i< nums.length; i++) {
           if (nums[i] > 0) {
               resultList.add(i + 1);
           }
       }
       return resultList;
    }

}
