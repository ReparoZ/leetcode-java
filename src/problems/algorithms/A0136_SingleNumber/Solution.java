package problems.algorithms.A0136_SingleNumber;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/24
 */
public class Solution {

    /**
     * 利用异或，任意两个数字异或之后为0，0和任意数字异或还是原来的数字，因此全部数字异或后，重复数字会抵消，最后留下的就是不重复的
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 38.6 MB, 40.80%
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (final int i : nums) {
            num ^= i;
        }
        return num;
    }
}
