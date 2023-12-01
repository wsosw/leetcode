package 暴力求解;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // 求字符串中回文字串的个数
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();

        if (str.length() == 0) {
            System.out.println(0);
            return;
        }

        ArrayList<String> list = new ArrayList<>();

        int start = 0;
        while (start < str.length()) {

            String tempStr = "";
            String reverseStr = "";
            for (int i = start; i < str.length(); i++) {
                tempStr += String.valueOf(str.charAt(i));
                reverseStr = str.charAt(i) + reverseStr;

                if (tempStr.equals(reverseStr)) {
                    list.add(tempStr);
                }
            }

            start++;
        }

        System.out.println(list.size());


    }

    
}
