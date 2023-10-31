package 栈相关.Q20_有效的括号;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }


            if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
            if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
            if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
        }

        return stack.isEmpty();

    }


}
