package leetCodeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 买卖股票的最佳时机
 *
 * @author xmy
 * @date 2023/2/25 6:14 下午
 */
public class MaxProfit121 {

    public static void main(String[] args) {
        int[] prices = {7,6,5,4,3,1};
        int i = maxProfit(prices);
        System.out.println("最大利润" + i);
    }


    public static int maxProfit(int[] prices) {
        //思想：第i天的最大利润 = Max{前i-1天的最大收益， 第i天的价格-第i-1天的价格}
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[prices.length - 1];
        //自己的解法会超时
//        if (prices.length <= 1) {
//            return 0;
//        }
//
//        int maxProfit = 0;
//        for (int i = 0; i + 1 < prices.length; i++) {
//            int temp = prices[i];
//            for (int j = i + 1; j < prices.length; j++) {
//                maxProfit = Math.max(maxProfit, prices[j] - temp);
//            }
//        }
//        return maxProfit;
    }
}
