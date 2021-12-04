package problems.algorithms.A0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/12/5
 */
public class Solution {

    /**
     * 因为不能包含重复的三元组，并且我们需要排序数组帮我们精确的找到对应的元组，
     * 在排序后，首先确定一个数字（假设index为first），则需要在大于他的子数组（排序好的）中，找到两个数字（可能有多组）加起来等于0
     * 则可以使用双指针，因为如果出现两组数字（a1，b1）（a2，b2）加起来都等于第一个数字的相反数的话
     * 必然a1<a2 && b1>b2 或者 a1>a2 && b1 < b2
     * 指针1指向first + 1，指针2指向末尾，每次右移指针1时，持续左移指针2视图找到对应的三元组
     *
     * 时间复杂度 : O(n^2).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 21 ms, 65.99%
     * Memory Usage: 42.1 MB, 75.49%
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> answer = new ArrayList<>();
        for (int first = 0; first < nums.length && nums[first] <= 0; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = nums.length - 1, target = -nums[first];
            for (int second = first + 1; second < nums.length; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == -nums[first]) {
                    answer.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }

        return answer;
    }
}
