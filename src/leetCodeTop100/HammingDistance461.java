package leetCodeTop100;

/**
 * 446. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 *
 * @author xmy
 * @date 2023/3/20 10:20 下午
 */
public class HammingDistance461 {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        int t = x ^ y;
        while (t != 0) {
            ans += t % 2;
            t /= 2;
        }
        return ans;
    }
}
