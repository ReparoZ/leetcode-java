package problems.algorithms.A0695_MaxAreaOfIsland;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 示例 1：
 * https://assets.leetcode.com/uploads/2021/05/01/maxarea1-grid.jpg
 *
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 *
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * 
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/11/17
 */
public class Solution {

    /**
     * 深度优先搜索/广度优先搜索
     *
     * 时间复杂度 : O(nm).
     * 空间复杂度 : O(nm).
     *
     * 解答消耗参考:
     * Runtime: 3 ms, 50.28%
     * Memory Usage: 39.0 MB, 47.84%
     */
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] cellVisited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!cellVisited[i][j]) {
                    maxArea = Math.max(maxArea, maxAreaOfThis(grid, cellVisited, i, j));
                }
            }
        }

        return maxArea;
    }

    private int maxAreaOfThis(int[][] grid, boolean[][] visited, int startX, int startY) {
        if (startX < 0 || startX >= grid.length) {
            return 0;
        }

        if (startY < 0 || startY >= grid[0].length) {
            return 0;
        }

        if (visited[startX][startY]) {
            return 0;
        } else {
            visited[startX][startY] = true;
        }

        if (grid[startX][startY] == 0) {
            return 0;
        }

        int area = 1;
        area += maxAreaOfThis(grid, visited, startX + 1, startY);
        area += maxAreaOfThis(grid, visited, startX - 1, startY);
        area += maxAreaOfThis(grid, visited, startX, startY + 1);
        area += maxAreaOfThis(grid, visited, startX, startY - 1);

        return area;
    }
}
