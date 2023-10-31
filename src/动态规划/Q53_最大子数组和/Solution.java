package 动态规划.Q53_最大子数组和;

public class Solution {

    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int tempSum = 0;

        for (int num : nums) {
            if (tempSum > 0) {
                tempSum += num;
            } else {
                tempSum = num;
            }
            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }


}
