package 数组相关.Q56_合并区间;

import java.util.*;

public class Solution {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][2];

        // 对每个子区间按起点排序，得到的结果中每个元素的起点一定大于等于前一个元素的起点
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                // 比较结果集中最后一个元素和当前元素的区间终点，取最大值
                // 这里无需关心区间起点值，因为上边已经对所有元素按起点值排序了
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
