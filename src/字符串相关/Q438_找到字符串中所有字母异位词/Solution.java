package 字符串相关.Q438_找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public List<Integer> findAnagrams(String s, String p) {


        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) return res;

        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);

        for (int i = 0; i < s.length() - p.length() + 1; i++) {

            char[] chars = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(chars);

            if (Arrays.equals(chars, pChars)) {
                res.add(i);
            }
        }

        return res;
    }


}
