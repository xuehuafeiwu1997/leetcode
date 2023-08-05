package leetCodeTop100;

/**
 * 11. 盛最多水的容器
 *
 *
 * @author xmy
 * @date 2023/8/5 15:25
 */
public class MaxArea11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 1};
        MaxArea11 maxArea11 = new MaxArea11();
        int i = maxArea11.maxArea2(height);
        System.out.println("容器能够盛的最多水为" + i);
    }

    //1. 自己的解法，时间复杂度o(n2),leetcode上会超时
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] ans = new int[height.length];
        ans[0] = 0;
        for (int i = 0; i < height.length; i++) {
          for (int j = 0; j < height.length; j++) {
              //得到每个位置的最大面积值
              ans[i] = Math.max(ans[i], Math.min(height[i], height[j]) * (j - i));
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            result = Math.max(result, ans[i]);
        }
        return result;
    }

    //2.双指针的解法
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left++]);
                //谁矮就需要移动谁，两边的高由矮的决定
            } else {
                res = Math.max(res, (right - left) * height[right--]);
            }
        }
        return res;
    }


}
