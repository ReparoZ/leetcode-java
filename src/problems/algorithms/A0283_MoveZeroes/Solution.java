package problems.algorithms.A0283_MoveZeroes;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/13
 */
public class Solution {

    /**
     * 解 1：记录最后一个0的位置，遇到非0则与他交换，如果出现连续的0就移动最后一个0的位置
     *
     * 解答消耗参考:
     * Runtime: 2 ms, 38.27%
     * Memory Usage: 39.7 MB, 22.42%
     */
    public void moveZeroes(int[] nums) {
        int lastZero = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i < lastZero) {
                lastZero = i;
            } else if (nums[i] != 0 && i > lastZero) {
                nums[lastZero] = nums[i];
                nums[i] = 0;
                if (nums[lastZero + 1] == 0) {
                    lastZero++;
                } else {
                    lastZero = Integer.MAX_VALUE;
                }
            }
        }
    }
}
