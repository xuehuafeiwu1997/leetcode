package leetCodeTop100.other;

/**
 * 2609. 查找最长平衡子串
 * 链接：https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。 
 *
 * @author xmy
 * @date 2023/5/4 7:45 下午
 */
public class FindMaxLength {
    public static void main(String[] args) {
        String s = "01000111";
    }

    public int findTheLongestBalancedSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //结果值
        int ans = 0;
        //上一段连续相同字符个数
        int pre = 0;
        //当前连续相同字符串个数
        int cur = 0;
        //转换成字符数组
        char[] chars =  s.toCharArray();
        //数组的length不需要括号，string的length需要括号， size也需要括号
        for(int i = 0; i <chars.length; i++) {
            ++cur;
            if ( i == s.length() - 1 || chars[i] != chars[i + 1]) {
                if(chars[i] == '1') {
                    ans = Math.max(ans, Math.min(pre, cur) * 2);
                }
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
