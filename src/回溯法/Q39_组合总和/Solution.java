package 回溯法.Q39_组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> res = new ArrayList<>();

        if (candidates.length == 0) return res;


        ArrayList<Integer> path = new ArrayList<>();
        dfs(candidates, 0, candidates.length, target, path, res);

        return res;

    }

    private void dfs(int[] candidates, int begin, int len, int target, ArrayList<Integer> path, List<List<Integer>> res) {

        // 小于0，说明当前path中的元素之和已经大于目标值，不匹配直接返回（可以直接返回的原因是题目中规定了元素都是不同的正整数）
        if (target < 0) return;

        // 等于0，说明当前path中的元素之和等于目标值，已经匹配，但要注意，不能将path直接添加到res中，要考虑值传递和引用传递的区别（也就是深浅拷贝）
        if (target == 0) res.add(new ArrayList<>(path));

        // 回溯法
        for (int i = begin; i < len; i++) {

            path.add(candidates[i]);

            System.out.println(Arrays.toString(path.toArray()));

            // 这里类似全排列，每一轮dfs搜索从i开始而不是从0开始，目的就是为了去除重复数据（可理解为Ann和Cnn的区别）
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 如果path不为空，将集合中最后一个元素移除
            if (!path.isEmpty()) path.remove(path.size() - 1);

        }


    }


    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(result);
    }



}
