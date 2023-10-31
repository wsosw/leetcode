package 动态规划.Q32_最长有效括号;

public class Solution {

    public int longestValidParentheses(String s) {

        if (s.length() == 0) return 0;

        int maxLength = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        return maxLength;
    }


}
