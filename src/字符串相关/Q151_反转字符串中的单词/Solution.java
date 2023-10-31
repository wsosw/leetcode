package 字符串相关.Q151_反转字符串中的单词;

public class Solution {

    public String reverseWords(String s) {

        String res = "";

        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >=0 ; i--) {
            res += " " + words[i];
        }

        return res.trim();


    }


}
