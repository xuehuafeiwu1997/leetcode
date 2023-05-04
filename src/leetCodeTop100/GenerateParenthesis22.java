package leetCodeTop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 *链接：https://leetcode.cn/problems/generate-parentheses/
 *
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author xmy
 * @date 2023/5/4 8:07 下午
 */
public class GenerateParenthesis22 {

    List<String> res = new ArrayList<>();

    //方法一：剪枝 + 回溯（DFS）
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        dfs("", n ,n);
        return res;
    }

    /**
     *
     * @param currStr 当前递归得到的结果
     * @param left 左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     */
    private void dfs(String currStr, int left, int right) {
        if (left == 0 && left == right) {
            res.add(currStr);
            return;
        }
        //剪枝,如果剩余使用的左括号的数量大于右括号，那就剪枝
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(currStr + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(currStr + ")", left, right - 1);
        }

    }
}
