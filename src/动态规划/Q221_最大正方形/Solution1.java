package 动态规划.Q221_最大正方形;

// 暴力破解
public class Solution1 {

    public int maximalSquare(char[][] matrix) {

        int maxSide = 0;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // 按行遍历
        OUT:
        for (int i = 0; i < rowSize; i++) {
            // 按列遍历
            for (int j = 0; j < colSize; j++) {

                // 每个元素都当成正方形的左上角，然后向外延伸
                char leftUpCorner = matrix[i][j];
                if (leftUpCorner == '1') {

                    int side = 1;
                    int rightPointer = j, downPointer = i;

                    IN:
                    while (++downPointer < rowSize && ++rightPointer < colSize) {

                        // 每次边界指针移动后，都要判断指针所对应的行和列数据是否都等于1
                        for (int right = j; right <= rightPointer; right++) {
                            if (matrix[downPointer][right] != '1') break IN;
                        }
                        for (int down = i; down <= downPointer; down++) {
                            if (matrix[down][rightPointer] != '1') break IN;
                        }

                        side++;
                    }

                    maxSide = Math.max(maxSide, side);
                    if (maxSide == rowSize || maxSide == colSize) break OUT;
                }
            }
        }

        return maxSide * maxSide;
    }


    public static void main(String[] args) {
        new Solution1().maximalSquare(new char[][]{{'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}});
    }



}
