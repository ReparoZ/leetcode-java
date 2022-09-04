package problems.algorithms.A1582_SpecialPositionsInABinaryMatrix;

/**
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * <p>
 *
 *
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],
 *            [0,0,1],
 *            [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],
 *            [0,1,0],
 *            [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 * <p>
 * 输入：mat = [[0,0,0,1],
 *            [1,0,0,0],
 *            [0,1,1,0],
 *            [0,0,0,0]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：mat = [[0,0,0,0,0],
 *            [1,0,0,0,0],
 *            [0,1,0,0,0],
 *            [0,0,1,0,0],
 *            [0,0,0,1,1]]
 * 输出：3
 * <p>
 *
 * 提示：
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/9/4
 */
public class Solution {

    /**
     * 原题要求的，就是行数字之和与列数字之和都为1，且行列交叉点的数字为1，无难度
     * <p>
     * 时间复杂度 : O(m * n)
     * 空间复杂度 : O(m + n)
     * <p>
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 41.6 MB, 53.02%
     */
    public int numSpecial(int[][] mat) {
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];

        for (int i = 0; i < rowCount.length; i++) {
            for (int j = 0; j < colCount.length; j++) {
                rowCount[i] += mat[i][j];
                colCount[j] += mat[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < rowCount.length; i++) {
            for (int j = 0; j < colCount.length; j++) {
                if (rowCount[i] == 1 && colCount[j] == 1 && mat[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
