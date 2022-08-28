package problems.algorithms.A0986_IntervalListIntersections;

import java.util.ArrayList;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * <p>
 *
 * 示例 1：
 * <a href="https://assets.leetcode.com/uploads/2019/01/30/interval1.png">...</a>
 * <p>
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 * <p>
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * <p>
 *
 * 提示：
 * <p>
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= start_i < end_i <= 10^9
 * end_i < start_i+1
 * 0 <= start_j < end_j <= 10^9
 * end_j < start_j+1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/interval-list-intersections">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/08/29
 */
public class Solution {

    /**
     * 难点1：如何判断两个集合相交的部分？
     * 相交的部分的左值一定是两个左值里面最大的，右值一定是两个右值里最小的，再看这个左右值本身是不是符合左小于右就可以
     * <p>
     * 难点2：怎么遍历两个列表？
     * 不是每边各+1，因为可能某个区间一直包含着另一个列表的区间，所以一定要等到某个列表的区间超过另一个列表的区间，才能让另一个列表滑动到下一个区间
     * <p>
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     * <p>
     * 解答消耗参考:
     * Runtime: 2 ms, 99.89%
     * Memory Usage: 42.2 MB, 53.82%
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][] {};
        }

        final ArrayList<int[]> result = new ArrayList<>();
        int firstListIndex = 0, secondListIndex = 0;
        while (true) {
            final int[] first = firstList[firstListIndex];
            final int[] second = secondList[secondListIndex];
            final int[] intersection = calIntersection(first, second);
            if (intersection != null) {
                result.add(intersection);
            }

            if (first[1] >= second[1] && secondListIndex < secondList.length - 1) {
                secondListIndex++;
            } else if (firstListIndex < firstList.length - 1) {
                firstListIndex++;
            } else {
                break;
            }
        }

        return result.toArray(new int[][] {});
    }

    private int[] calIntersection(final int[] first, final int[] second) {
        int leftIndex = Math.max(first[0], second[0]);
        int rightIndex = Math.min(first[1], second[1]);
        if (rightIndex < leftIndex) {
            return null;
        } else {
            return new int[] {leftIndex, rightIndex};
        }
    }
}
