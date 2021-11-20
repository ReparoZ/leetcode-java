package problems.algorithms.A0077_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/11/21
 */
public class Solution {

    /**
     * 递归解法，确认某一个数之后，递归后面的序列
     *
     * 时间复杂度 : O(combine(n, k)).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 99.97%
     * Memory Usage: 39.8 MB, 34.24%
     */
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> allCombine = new ArrayList<>();
        combineNum(allCombine, new ArrayList<>(), null, n, k);
        return allCombine;
    }

    public void combineNum(final List<List<Integer>> resultList,
                           final List<Integer> prevCombine, Integer thisNum, int n, int k) {
        final List<Integer> thisCombine = new ArrayList<>(prevCombine);
        if (thisNum != null) {
            thisCombine.add(thisNum);
        }

        if (prevCombine.size() + 1 == k && thisNum != null) {
            resultList.add(thisCombine);
        } else {
            for (int i = thisNum == null ? 1 : thisNum + 1; i <= n - k + thisCombine.size() + 1; i++) {
                combineNum(resultList, thisCombine, i, n, k);
            }
        }
    }
}
