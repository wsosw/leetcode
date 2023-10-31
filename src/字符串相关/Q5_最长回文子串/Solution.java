package 字符串相关.Q5_最长回文子串;

// 暴力破解法，力扣只能通过90%，赛码网通过率100%
public class Solution {


    public String longestPalindrome(String s) {

        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {

            String tempStr = "";
            String reverseStr = "";
            for (int j = i; j < s.length(); j++) {
                tempStr = tempStr + s.charAt(j);
                reverseStr = s.charAt(j) + reverseStr;
                if (tempStr.equals(reverseStr)) {
                    maxStr = maxStr.length() >= tempStr.length() ? maxStr : tempStr;
                }
            }
        }

        return maxStr;
    }


    public static void main(String[] args) {
        new Solution().longestPalindrome("cbbd");
    }


}
