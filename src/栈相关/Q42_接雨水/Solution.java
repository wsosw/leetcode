package 栈相关.Q42_接雨水;


// todo 还没写上来

public class Solution {

    public int trap(int[] height) {

        // 如果长度小于3，不可能形成槽位
        if (height.length < 3) return 0;

        int left = 0;
        int right = 1;
        int sum = 0;
        int maxHeight = 0;

        // 首先要找到数组最左边的的一个长板
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > height[i + 1]) {
                left = i;
                right = i + 1;
                break;
            }
        }

//        while (right < height.length) {
//
//
//
//
//            right++;
//        }


        return sum;
    }

}
