package 双指针.Q11_盛最多水的容器;

public class Solution {

    public int maxArea(int[] height) {


        // 麻辣隔壁，超时...
        // int area;
        // int maxArea = 0;
        //
        // for (int i = 0; i < height.length - 1; i++) {
        //     for (int j = i + 1; j < height.length; j++) {
        //         area = (j - i) * Math.min(height[i], height[j]);
        //         if (area >= maxArea) maxArea = area;
        //     }
        // }

        int area;
        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        // i, j 两端高度相同时，如果它们中间如果存在更大的面积，构成这个更大面积的两端 p, q 必然和 i, j 无关。
        // (i < p < q< j) 因为这个更大的面积宽度更小，需要更大的高度。 所以不会错过最大面积。
        // 即有：(i < p < q< j) => (height[p] || height[q]) > height[i||j]
        while (i < j) {
            area = height[i] < height[j] ? (j - i) * height[i++] : (j - i) * height[j--];
            if (area > maxArea) maxArea = area;
        }


        return maxArea;
    }


}
