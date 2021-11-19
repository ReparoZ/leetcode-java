package problems.algorithms.A0542_01Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1：
 * https://pic.leetcode-cn.com/1626667201-NCWmuP-image.png
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 * https://pic.leetcode-cn.com/1626667205-xFxIeK-image.png
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/20
 */
public class Solution {

    /**
     * 由于原矩阵由0和1组成，该题可以转换为在新答案矩阵里填空
     * 1. 先将原矩阵为0的填为0
     * 2. 答案矩阵为0的格子的直接相邻且未填值的格子填为1
     * 3. 答案矩阵为1的格子的直接相邻且未填值的格子填为2
     * 4. 以此类推
     *
     * 时间复杂度 : O(nm), n为矩阵行数，m为矩阵列数.
     * 空间复杂度 : O(nm), n为矩阵行数，m为矩阵列数.
     *
     * 解答消耗参考:
     * Runtime: 33 ms, 5.07%
     * Memory Usage: 40.8 MB, 79.22%
     */
    public int[][] updateMatrix(int[][] mat) {
        List<List<Integer>> curPair = new ArrayList<>();
        int countPair = 0, curDistance = 0;
        int[][] resultMap = new int[mat.length][mat[0].length];
        while (countPair < mat.length * mat[0].length) {
            if (curDistance == 0) {
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        if (mat[i][j] == 0) {
                            curPair.add(List.of(i, j));
                        } else {
                            resultMap[i][j] = Integer.MAX_VALUE;
                        }
                    }
                }
            } else {
                curPair = fillNum(resultMap, curDistance, curPair);
            }

            countPair += curPair.size();
            curDistance++;
        }

        return resultMap;
    }

    public List<List<Integer>> fillNum(int[][] resultMap, int filledNum, List<List<Integer>> lastPair) {
        final List<List<Integer>> curPair = new ArrayList<>();
        for (List<Integer> integers : lastPair) {
            final Integer row = integers.get(0);
            final Integer col = integers.get(1);

            fillNum(resultMap, row + 1, col, filledNum, curPair);
            fillNum(resultMap, row - 1, col, filledNum, curPair);
            fillNum(resultMap, row, col + 1, filledNum, curPair);
            fillNum(resultMap, row, col - 1, filledNum, curPair);
        }

        return curPair;
    }

    private void fillNum(int[][] resultMap, int row, int col, int filledNum, List<List<Integer>> curPair) {
        if (row < 0 || row >= resultMap.length || col < 0 || col >= resultMap[0].length) {
            return;
        }

        if (filledNum < resultMap[row][col]) {
            resultMap[row][col] = filledNum;
            curPair.add(List.of(row, col));
        }
    }
}
