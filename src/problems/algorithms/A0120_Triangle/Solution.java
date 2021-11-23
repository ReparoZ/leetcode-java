package problems.algorithms.A0120_Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 * 
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/23
 */
public class Solution {

    /**
     * 动态规划
     * 从最后一层开始算起，f(i, j) = triangle(i, j) + Min(f(i, j - 1), f(i - 1, j - 1))
     *
     * 时间复杂度 : O(n^2).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 7 ms, 12.62%
     * Memory Usage: 38.1 MB, 58.37%
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRowRes = new ArrayList<>();
        prevRowRes.add(0);
        for (List<Integer> curRow : triangle) {
            final List<Integer> curRowRes = new ArrayList<>();
            for (int i = 0; i < curRow.size(); i++) {
                curRowRes.add(curRow.get(i) + Math.min(i == prevRowRes.size() ? Integer.MAX_VALUE : prevRowRes.get(i), i == 0 ? Integer.MAX_VALUE : prevRowRes.get(i - 1)));
            }
            prevRowRes = curRowRes;
        }

        int minTotal = Integer.MAX_VALUE;
        for (Integer prevRowRe : prevRowRes) {
            minTotal = Math.min(minTotal, prevRowRe);
        }
        return minTotal;
    }
}
