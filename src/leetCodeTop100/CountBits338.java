package leetCodeTop100;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * 另外，java中有内置的类Integer.bitCount
 *
 *  参考题解：https://leetcode.cn/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
 * @author xmy
 * @date 2023/3/19 7:51 下午
 */
public class CountBits338 {
    public static void main(String[] args) {
        int[] ints = countBits(2);
        Arrays.stream(ints).forEach(i -> System.out.println(i));
    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0]= 0;
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 1) {
                result[i] = result[i -1] + 1; //奇数是前一个偶数的最后一位为1
            } else {
                result[i] = result[i / 2]; //二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
            }
        }
        return result;
    }
}
