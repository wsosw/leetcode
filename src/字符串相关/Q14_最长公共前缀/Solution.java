package 字符串相关.Q14_最长公共前缀;

public class Solution {


    public String longestCommonPrefix(String[] strs) {

        String sss = strs[0];
        int index = sss.length();

        OUT:
        for (int i = 0; i < sss.length(); i++) {
            char ch = sss.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    index = i;
                    break OUT;
                }
            }
        }

        return sss.substring(0, index);
    }

    public static void main(String[] args) {
        new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }


}
