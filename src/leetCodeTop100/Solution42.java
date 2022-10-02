package leetCodeTop100;

/**
 * leetcode top 100 接雨水
 * 参考题解：https://leetcode.cn/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 *
 * @author xmy
 * @date 2022/10/2 9:54 下午
 */
public class Solution42 {
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum = trapSolutiongFirst(height);
        System.out.println("接雨水的总数" + sum);

    }

    /**
     * 解法一  按照列来求
     * 时间复杂度：O（n²），遍历每一列都需要n，找出左边最高和右边最高的墙加起来刚好又是一个n，所以是n²
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public static int trapSolutiongFirst(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //找出当前列（i）最左边的高度
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            //找出当前列（j）最右边的高度
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水,而且水的高度就是最小值减去当前列
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}


