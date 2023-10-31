package 回溯法.Q46_全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {

        ArrayList<List<Integer>> res = new ArrayList<>();


        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }


        backtrack(nums.length, list, res, 0);
        return res;
    }


    public void backtrack(int n, List<Integer> list, List<List<Integer>> res, int first) {

        if (first == n) {
            res.add(new ArrayList<>(list));
        }

        for (int i = first; i < n; i++) {

            Collections.swap(list, first, i);

            backtrack(n, list, res, first + 1);

            Collections.swap(list, first, i);

        }

    }


}
