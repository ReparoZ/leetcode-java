package problems.algorithms.A0190_ReverseBits;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 * 
 *
 * 示例 1：
 *
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * 示例 2：
 *
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * 
 *
 * 提示：
 *
 * 输入是一个长度为 32 的二进制字符串
 *
 *
 * 进阶: 如果多次调用这个函数，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/25
 */
public class Solution {

    /**
     * 位运算分治
     * 与之前做过的类似字符串翻转之类的类似，整体翻转操作本来就可以理解为内部每个子项翻转，再整体翻转，因此这个题目可以理解为，翻转多次奇偶
     * 四步其实基本是一个意思，第一步的0x55555555的二进制表示为0101010101....
     * 因此第一步n >>> 1 & 0x55555555的意思是先将奇数位的移到偶数位上，然后取移位后偶数位上的1（也就是原先奇数位的1）
     * (n & 0x55555555) << 1的意思是，取偶数位的1，将其左移到奇数位上
     * 再通过或的方式，结合奇偶为上的1，举例数字1101，先获取0100，在获取1010，在或出一个1110，也就是说将奇偶位反序
     * 第二步和第一步同理，0x33333333也就是0011001100110011，将每两位bit看做一个整体完成奇偶互换
     * 第三步是将每四个bit看做一个整体进行奇偶互换
     * 第四步是将每八个bit看做一个整体进行奇偶互换
     * 最后就是直接把前16bit和后16bit互换
     *
     * 时间复杂度 : O(1).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 96.72%
     * Memory Usage: 38.2 MB, 30.34%
     */
    public int reverseBits(int n) {
        n = n >>> 1 & 0x55555555 | (n & 0x55555555) << 1;
        n = n >>> 2 & 0x33333333 | (n & 0x33333333) << 2;
        n = n >>> 4 & 0x0f0f0f0f | (n & 0x0f0f0f0f) << 4;
        n = n >>> 8 & 0x00ff00ff | (n & 0x00ff00ff) << 8;
        return n >>> 16 | n << 16;
    }
}
