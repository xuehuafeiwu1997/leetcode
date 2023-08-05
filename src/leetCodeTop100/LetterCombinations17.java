package leetCodeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的数字组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 *
 * @author xmy
 * @date 2023/4/21 8:02 下午
 */
public class LetterCombinations17 {
    public static void main(String[] args) {

    }

    //设置全局列表存储最后的结果
    public static List<String> list = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        //回溯法
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增两个无效的字符串
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        return list;
    }

    //每次迭代获取一个字符串，所以会涉及大量的字符串拼接，所以这里选择更为高效的StringBuilder
    StringBuilder stringBuilder = new StringBuilder();

    public void backTracking(String digits, String[] numString, int num) {
        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            list.add(stringBuilder.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            //剔除末尾的继续尝试
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
