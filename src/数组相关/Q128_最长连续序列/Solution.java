package 数组相关.Q128_最长连续序列;


import java.util.Arrays;

/**
 * 解题思路：
 *   1. 首先对数组元素从小到大排序
 *   2. 创建三个辅助变量：
 *      maxSequenceLength -> 记录所有连续序列长度的最大值
 *      currentSequenceLength -> 记录当前连续序列的长度
 *      before -> 永远在本次计算完成后指向本次的遍历对象
 *   3. 如果当前遍历对象的值和before的值是连续的（nums[i] == before + 1），则当前序列长度要+1，且要和最大序列长度比较并更新
 *   4. 注意如果前后两个值相等的情况下，这对连续序列没有任何影响，什么都不做，直接跳到下一次循环
 */
public class Solution {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        int before = nums[0];   // 记录遍历元素的上一个元素的值
        int maxSequenceLength = 1;  // 记录最大长度序列
        int currentSequenceLength = 1;  // 记录当前组序列长度

        for (int i = 1; i < nums.length; i++) {

            // 这步很重要：如果与上一个值相等什么也不做
            if (nums[i] == before) continue;

            if (nums[i] == before + 1) {
                currentSequenceLength++;
            } else {
                currentSequenceLength = 1;
            }

            if (currentSequenceLength > maxSequenceLength) maxSequenceLength = currentSequenceLength;

            before = nums[i];

        }

        return maxSequenceLength;

    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int max = new Solution().longestConsecutive(nums);
        System.out.println(max);
    }


}
