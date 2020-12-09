package problems.algorithms.A0062_UniquePaths;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 
 *
 * 示例1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * 
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/09
 */
public class Solution {

    /**
     * 解 1：排列组合解法，通过m，n能够确定向右或者向下的次数，总共需要移动m-1次向右，n-1次向下
     * 假设m>n，则可以理解为将n插入m次步数，有多少种插法，也就是C(m-1, m+n-2)次
     *
     * 时间复杂度 : O(min(m, n)).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 35.2 MB, 74.75%
     */
    public int uniquePaths1(int m, int n) {
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }

        long insertNum = 1, permutateNum = 1;
        for (int i = 0; i < n - 1; i++) {
            insertNum *= (m + i);
            permutateNum *= (i + 1);
        }

        return (int) (insertNum / permutateNum);
    }

    /**
     * 解 2：原理和解1一样，不替换m和n，为了解决溢出的问题，使用了BigInteger
     *
     * 时间复杂度 : O(min(m, n)).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 2 ms, 9.42%
     * Memory Usage: 35.6 MB, 30.43%
     */
    public int uniquePaths2(int m, int n) {
        BigInteger insertNum = BigInteger.ONE, permutateNum = BigInteger.ONE;
        for (int i = 0; i < n - 1; i++) {
            insertNum = insertNum.multiply(BigInteger.valueOf(m + i));
            permutateNum = permutateNum.multiply(BigInteger.valueOf(i + 1));
        }

        return insertNum.divide(permutateNum).intValue();
    }

    /**
     * 解 3：动态规划，正算，因为uniquePaths(m, n) = uniquePaths(m - 1, n) + uniquePaths(m, n - 1)，
     * 因此可以从0，0单元格开始，用迭代的方式进行计算，但此方法迭代层数过深，时间超长且超栈
     *
     * 时间复杂度 : O(mn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 超时
     * Memory Usage: 超时
     */
    public int uniquePaths3(int m, int n) {
        return m == 1 && n == 1 ? 1 : (m > 1 ? uniquePaths3(m - 1, n) : 0) + (n > 1 ? uniquePaths3(m, n - 1) : 0);
    }

    /**
     * 解 4：方法同解3，使用了一个二维数组保存结果
     *
     * 时间复杂度 : O(mn).
     * 空间复杂度 : O(mn).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 35.4 MB, 51.62%
     */
    public int uniquePaths4(int m, int n) {
        final int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
