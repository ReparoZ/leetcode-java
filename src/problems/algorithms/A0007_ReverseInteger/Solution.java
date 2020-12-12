package problems.algorithms.A0007_ReverseInteger;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例1:
 *
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−2^31, 2^31− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/13
 */
public class Solution {

    /**
     * 解 1：在每一次翻转之前判断结果将会不会超出原类型的边界。经分析可知，只要之前判断了，
     * 则reversed = reversed * 10 + x % 10; 这一步是不会超出边界的。
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 35.5 MB, 80.44%
     */
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
                return 0;
            }

            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }
}
