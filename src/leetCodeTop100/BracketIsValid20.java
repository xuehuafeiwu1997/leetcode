package leetCodeTop100;

import java.util.Stack;

/**
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 使用栈的思路来解决
 * @author xmy
 * @date 2023/2/23 8:35 下午
 */
public class BracketIsValid20 {


    public static void main(String[] args) {
        String s =  "()";
        boolean valid = isValid(s);
        System.out.println(valid);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if ( c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
         }
        return stack.isEmpty();
    }
}
