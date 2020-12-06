package problems.algorithms.A0861_ScoreAfterFlippingMatrix;

/**
 * 有一个二维矩阵A 其中每个元素的值为0或1。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 * 
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j]是0 或1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/07
 */
public class Solution {

    /**
     * 解 1: 由于是二进制，且由于是按行或者是按列翻转，所以对于
     * 任何一个矩阵元素来说，只有不翻转，被行翻转，被列翻转，被行列翻转四种情况，
     * 且为了达到最大值，翻转的其中一个原则是，第一位必须为1（二进制规则），所以是否被列翻转是已知的
     * 因此只用看任意列的元素是否被行翻转，在这两种情况中，找每一列1最多的一种翻转方式即可
     *
     * 时间复杂度 : O(mn).
     * 空间复杂度 : O(mn).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.3 MB, 69.75%
     */
    public int matrixScore1(int[][] A) {
        int[][] reversedMatrix = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                reversedMatrix[j][i] = A[i][j];
            }
        }

        int[] firstCol = new int[reversedMatrix[0].length];
        for (int i = 0; i < reversedMatrix[0].length; i++) {
            firstCol[i] = reversedMatrix[0][i] == 0 ? 1 : 0;
        }

        int result = 0;
        for (int i = 0; i < reversedMatrix.length; i++) {
            final int oneNum = calRowOne(reversedMatrix[i], firstCol);
            result += oneNum * (1 << (reversedMatrix.length - i - 1));
        }

        return result;
    }

    /**
     * 解 2：与解1原理一样，但直接在原矩阵上操作
     *
     * 时间复杂度 : O(mn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.3 MB, 81.78%
     */
    public int matrixScore2(int[][] A) {
        final int rowNum = A.length, colNum = A[0].length;
        int result = rowNum * (1 << (colNum - 1));

        for (int i = 1; i < colNum; i++) {
            int nOnes = 0;
            for (int[] rows : A) {
                if (rows[0] == 1) {
                    nOnes += rows[i];
                } else {
                    nOnes += (1 ^ rows[i]);
                }
            }
            int maxOnes = Math.max(nOnes, rowNum - nOnes);
            result += maxOnes * (1 << (colNum - i - 1));
        }
        return result;
    }

    public int calRowOne(int[] currRow, int[] flipRow) {
        int flipedRowOne = 0;
        for (int i = 0; i < currRow.length; i++) {
            final int currElem = currRow[i];
            final int flipedElem = currElem ^ flipRow[i];
            if (flipedElem == 1) {
                flipedRowOne++;
            }
        }

        return Math.max(flipedRowOne, currRow.length - flipedRowOne);
    }
}
