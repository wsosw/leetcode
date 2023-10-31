package exam;

import java.util.HashMap;
import java.util.Scanner;

public class JDExam {


    // 测试用例
    // 10 3 3 2
    // 1 5 4
    // 4 10 5
    // 题目2 => 正确率82% 超时了
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();

        int[] left = new int[m];
        int[] right = new int[m];


        for (int i = 0; i < m; i++) {
            left[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            right[i] = in.nextInt();
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int pointer = left[i];
            while (pointer <= right[i]) {
                if (!hashMap.containsKey(pointer)) {
                    hashMap.put(pointer, 1);
                } else {
                    hashMap.put(pointer, hashMap.get(pointer) + 1);
                }
                pointer++;
            }
        }


        int count = 0;
        OUT:
        for (int i = 1; i <= n; i++) {

            // 假设在第i天插入,剩余天数不够完成，直接跳出循环
            if (n - i + 1 < k) break;

            // 时间够用的情况
            IN:
            for (int j = i; j < i + k; j++) {
                if (hashMap.containsKey(j) && hashMap.getOrDefault(j, 0) >= a)
                    continue OUT;
            }

            count++;
        }

        System.out.println(count);


    }

//    // 题目1 => 正确率100%
//    public static void main(String[] args) {
//
//
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] nums = new int[n];
//
//        if (n == 0) {
//            System.out.println(-1);
//        } else {
//
//            for (int i = 0; i < n; i++) {
//                nums[i] = in.nextInt();
//            }
//
//            int pointer = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] - 1 == pointer) {
//                    pointer++;
//                }
//            }
//            if (pointer == 0) System.out.println(-1);
//            else System.out.println(n - pointer);
//        }
//
//
//    }


}
