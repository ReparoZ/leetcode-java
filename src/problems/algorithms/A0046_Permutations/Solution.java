package problems.algorithms.A0046_Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/21
 */
public class Solution {

    /**
     * 递归算法，通过start和end控制哪一些元素还没有被使用过，通过swap操作将已经使用的元素往前放
     *
     * 时间复杂度 : O(permute(nums.length)).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 2 ms, 15.50%
     * Memory Usage: 38.3 MB, 94.08%
     */
    public List<List<Integer>> permute(int[] nums) {
        final List<List<Integer>> resultList = new ArrayList<>();
        permute(resultList, new ArrayList<>(), nums, 0, nums.length - 1);
        return resultList;
    }

    public void permute(final List<List<Integer>> resultList, final List<Integer> curResult,
                        int[] nums, int start, int end) {
        if (start > end) {
            resultList.add(new ArrayList<>(curResult));
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(nums, start, i);
            curResult.add(nums[start]);
            permute(resultList, curResult, nums, start + 1, end);
            swap(nums, start, i);
            curResult.remove(curResult.size() - 1);
        }
    }

    public static void swap(final int[] nums, final int i, final int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
