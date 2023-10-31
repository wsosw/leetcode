package 栈相关.Q739_每日温度;

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);

        }
        return ans;
    }

}
