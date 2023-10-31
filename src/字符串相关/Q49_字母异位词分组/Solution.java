package 字符串相关.Q49_字母异位词分组;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 解题思路:
 *   1. 将字符串转换成一个字符数组
 *   2. 对字符数组进行排序，并重新转换成字符串
 *   3. 创建一个map，key为排序后的字符串，value为相同排序字符串的原字符串集合
 */
public class Solution {

    public static List<List<String>> groupAnagrams(String[] words) {

        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String word : words) {

            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortStr = Arrays.toString(charArray);

            if (hashMap.containsKey(sortStr)) {
                hashMap.get(sortStr).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                hashMap.put(sortStr, list);
            }
        }

        return new ArrayList<>(hashMap.values());

    }


}
