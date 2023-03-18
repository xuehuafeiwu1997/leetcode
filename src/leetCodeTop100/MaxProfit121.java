package leetCodeTop100;

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
        if (prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        for (int i = 0; i + 1 < prices.length; i++) {
            int temp = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - temp);
            }
        }
        return maxProfit;
    }
}
