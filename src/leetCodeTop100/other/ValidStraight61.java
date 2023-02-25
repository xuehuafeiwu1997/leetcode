package leetCodeTop100.other;

import java.util.HashSet;
import java.util.Set;

/**
 * 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * @author xmy
 * @date 2023/2/25 10:09 上午
 */
public class ValidStraight61 {
    public static void main(String[] args) {
        int[] nums = {4,7,5,9,2};
        boolean straight = isStraight(nums);
        System.out.println(straight);
    }

    public static  boolean isStraight(int[] nums) {
        Set numsSet = new HashSet();
        int max = 0;
        int min = 14;
        for (int item : nums) {
            if (item == 0) {
                continue;
            }
            if (numsSet.contains(item)) {
                return false;
            }
            max = Math.max(max, item);
            min = Math.min(min, item);
            numsSet.add(item);
        }
        return max - min <= 4;
    }

}
