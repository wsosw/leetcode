package 字符串相关.Q394_字符串解码;

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {

        String res = "";

        Stack<String> stack = new Stack<>();

        int pointer = 0;
        while (pointer < s.length()) {

            char ch = s.charAt(pointer);
            // 这里为了使碰见]字符处理简单写，直接在原有串上追加了信息
            if (!stack.isEmpty() && ((stack.peek().matches("\\d+") && Character.isDigit(ch)) || (stack.peek().matches("[a-z]+") && Character.isAlphabetic(ch)))) {
                stack.push(stack.pop() + ch);
            } else {
                stack.push(String.valueOf(ch));
            }

            if (ch == ']') {
                stack.pop();//]
                String tempStr = stack.pop();//str
                stack.pop();//[
                int tempNumber = Integer.parseInt(stack.pop());//num

                String str = "";
                for (int i = 0; i < tempNumber; i++) {
                    str += tempStr;
                }
                if (!stack.isEmpty() && stack.peek().matches("[a-z]+")) {// 要考虑嵌套的情况，如果是嵌套字符串，就追加到栈顶字符串上
                    stack.push(stack.pop() + str);
                } else {
                    stack.push(str);
                }
            }

            pointer++;
        }

        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        return res;
    }


    public static void main(String[] args) {
        new Solution().decodeString("3[a]2[bc2[2[ee]dd]]");
    }



}
