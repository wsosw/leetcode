package 暴力求解.Q239_滑动窗口最大值;

// todo 优化方法使用队列，写完后要更新到 "队列相关" 包里
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length < k) return nums;

        int[] res = new int[nums.length - k + 1];


        for (int i = 0; i < nums.length - k + 1; i++) {// 暴力破解是没问题，就是会他妈的超时~~

            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i+j]);
            }

            res[i] = max;
        }

        return res;
    }


}
