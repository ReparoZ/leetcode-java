package problems.algorithms.A0118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/06
 */
public class Solution {

    /**
     * 解 1：直接按照数学规律来做，没什么好说的
     *
     * 时间复杂度 : O(n^2).
     * 空间复杂度 : O(n^2).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.4 MB, 54.75%
     */
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            final List<Integer> prevRow = i > 1 ? result.get(i - 1) : null;
            final List<Integer> currentRow = new ArrayList<>(numRows + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            result.add(currentRow);
        }

        return result;
    }
}
