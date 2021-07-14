package problems.algorithms.A0080_MaximalRectangle;

/**
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 
 *
 * 示例 1：
 * https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 
 *
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/07/15
 */
public class Solution {

    /**
     * 解1：优化暴力解法
     * 定义一种矩形，对于任意一个坐标，找到这个点向上扩展的最大高度，然后向两边扩展，扩展到两边的高度小于最大高度时，就会得到这个矩形
     * 虽然这个矩形并不一定是包含该点的最大矩形，但是整个矩阵的最大矩形一定会包含在某一个点行程的这种矩形中
     * 找到每一个点的这样的矩形，并找到面积最大的那一个矩形
     *
     * 时间复杂度 : O(m^2 n).
     * 空间复杂度 : O(mn).
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        final int row = matrix.length, col = matrix[0].length;
        int maxRectangle = 0;
        final int[][] resultMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    resultMatrix[i][j] = 0;
                } else {
                    if (i == 0) {
                        resultMatrix[i][j] = 1;
                    } else {
                        resultMatrix[i][j] = resultMatrix[i - 1][j] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final int maxVert = resultMatrix[i][j];
                int cnt = 0;
                for (int k = j; k >= 0; k--) {
                    if (resultMatrix[i][k] >= maxVert) {
                        cnt++;
                    } else {
                        break;
                    }
                }

                for (int k = j + 1; k < col; k++) {
                    if (resultMatrix[i][k] >= maxVert) {
                        cnt++;
                    } else {
                        break;
                    }
                }

                maxRectangle = Math.max(maxRectangle, maxVert * cnt);
            }
        }

        return maxRectangle;
    }
}
