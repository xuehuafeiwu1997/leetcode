package leetCodeTop100;

import com.sun.tools.javac.util.StringUtils;

/**
 * 5.最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @author xmy
 * @date 2023/2/23 7:32 下午
 */
public class LongestPalindrome5 {

    private static final int MIN_NUMBER_CONST = 1;

    public static void main(String[] args) {
        System.out.println(3/2);
        String s = "ac";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }


    public static String longestPalindrome(String s) {
        int maxLength = 0;
        int resultStartIndex = 0;
        if (s == null || "".equals(s)) {
            return s;
        }

        //如果长度为1的情况，回文串就是他自身
        if (s.length() == MIN_NUMBER_CONST) {
            return s;
        }

        //如果长度大于1的情况
        maxLength = 0;
        for (int i = 0; i < s.length() - 1; i++) {

            for (int j = i + 1; j < s.length(); j++ ) {
                if (s.charAt(i) == s.charAt(j)) {
                    boolean flag = true;
                    for (int k = 1; k < (j - i) / 2 + 1; k++) {
                        if (s.charAt(i + k) != s.charAt(j - k)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if (j - i > maxLength) {
                            resultStartIndex = i;
                            maxLength = j - i;
                        }
                    }
                }
            }
        }

        return s.substring(resultStartIndex, maxLength + resultStartIndex + 1);
    }

}
