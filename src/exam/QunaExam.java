package exam;

public class QunaExam {

    // 去哪儿题目三 直接 return 0; 正确率46.47&
    public double percent (int N, int a, int b) {

        if (a > b) return 0;

        long validCount = 0;
        long totalCount = 0;

        // 最多抽 a 次，全是1的情况
        for (int i = 1; i <= a; i++) {

            totalCount += Math.pow(N, i);







        }






        return 0;

    }

    // 去哪儿题目二 正确率100%
    public int minPath (int[][] paths) {

        int rowNumber = paths.length;
        int colNumber = paths[0].length;

        int[][] dp = new int[rowNumber][colNumber];
        dp[0][0] = paths[0][0];

        for (int i = 1; i < rowNumber; i++) {
            dp[i][0] = paths[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < colNumber; i++) {
            dp[0][i] = paths[0][i] + dp[0][i-1];
        }


        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[i].length; j++) {
                dp[i][j] = paths[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[rowNumber-1][colNumber-1];
    }

    // 去哪儿题目一
    public String maxSubsequenceAndReverse (String string1, String string2) {

        String res = "";

        int shortLen = Math.min(string1.length(), string2.length());
        int longLen = Math.max(string1.length(), string2.length());

        if (shortLen == 0) return res;

        int[][] dp = new int[string1.length()][string2.length()];

        // 以短字符串的每个字符为结尾，动态规划
        for (int i = 0; i < string1.length(); i++) {
        }




        return res;

    }


    public static void main(String[] args) {

        new QunaExam().minPath(new int[][]{{1, 2, 1}, {1, 3, 4}, {5, 7, 8}});
    }






}
