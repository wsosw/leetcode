package 字符串相关.Q76_最小覆盖子串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    HashMap<Character, Integer> mapS = new HashMap<>();
    HashMap<Character, Integer> mapT = new HashMap<>();

    public String minWindow(String s, String t) {

        String res = "";

        if (s.length() < t.length()) return res;
        if (s.equals(t)) return t;

        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;

        String tempStr = "";
        while (end < s.length()) {

            char ch = s.charAt(end);
            tempStr += String.valueOf(ch);
            if (mapT.containsKey(ch)) {
                mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
            }

            while (start <= end && match()) {

                if ("".equals(res) || tempStr.length() < res.length()) {
                    res = tempStr;
                }

                char startChar = s.charAt(start);
                mapS.put(startChar, mapS.getOrDefault(startChar, 0) - 1);
                tempStr = tempStr.replaceFirst(String.valueOf(startChar), "");

                start++;
            }

            end++;
        }

        return res;
    }

    public boolean match() {
        Iterator<Map.Entry<Character, Integer>> iterator = mapT.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!mapS.containsKey(key) || mapS.get(key) < value) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String s = new Solution().minWindow("acbba", "aab");
        System.out.println(s);

    }


}
