package problems.algorithms.A0994_RottingOranges;

import java.util.ArrayList;
import java.util.List;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 *
 *
 * 示例 1：
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/16/oranges.png
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为0、1或2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/20
 */
public class Solution {

    /**
     * 由于原矩阵由0和1和2组成，该题可以转换从每一个2向上下左右扩张，然后从被扩张的新的2再向外扩张
     * 1. 先将原矩阵为1的填为2
     * 2. 上一轮为2的格子的直接相邻且为1的格子填为2
     * 3. 上一轮为2的格子的直接相邻且为1的格子填为2
     * 4. 以此类推
     *
     * 时间复杂度 : O(nm), n为矩阵行数，m为矩阵列数.
     * 空间复杂度 : O(nm), n为矩阵行数，m为矩阵列数.
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 37.60%
     * Memory Usage: 37.9 MB, 38.26%
     */
    public int orangesRotting(int[][] grid) {
        List<List<Integer>> curPair = new ArrayList<>();
        int freshCount = 0, min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    curPair.add(List.of(i, j));
                } else if (grid[i][j] == 1) {
                    freshCount += 1;
                }
            }
        }

        while (curPair.size() > 0) {
            curPair = rottingOrange(grid, curPair);
            if (curPair.size() > 0) {
                freshCount -= curPair.size();
                min++;
            }
        }

        return freshCount == 0 ? min : -1;
    }

    public List<List<Integer>> rottingOrange(final int[][] grid, final List<List<Integer>> lastRottingOrange) {
        final List<List<Integer>> curPair = new ArrayList<>();
        for (List<Integer> point : lastRottingOrange) {
            final Integer row = point.get(0);
            final Integer col = point.get(1);

            rottingAOrange(grid, row + 1, col, curPair);
            rottingAOrange(grid, row - 1, col, curPair);
            rottingAOrange(grid, row, col + 1, curPair);
            rottingAOrange(grid, row, col - 1, curPair);
        }

        return curPair;
    }

    public void rottingAOrange(final int[][] grid, final int row, final int col, final List<List<Integer>> curRottingOrange) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] != 0 && grid[row][col] != 2) {
            grid[row][col] = 2;
            curRottingOrange.add(List.of(row, col));
        }
    }
}
