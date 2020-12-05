package problems.algorithms.A002_AddTwoNumbers;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ml3426
 * @date 2020/12/05
 */
public class Solution {

    /**
     * 解 1: 自然数学解法，特别注意进位，特别是最后一个进位
     *
     * 时间复杂度 : O(Max(m, n)).
     * 空间复杂度 : O(Max(m, n)).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 38.9 MB, 51.40%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode r0 = new ListNode(0);
        ListNode pointer1 = l1, pointer2 = l2, pointerR = r0;
        int carry = 0;

        while (pointer1 != null || pointer2 != null) {
            final int num1 = pointer1 == null ? 0 : pointer1.val;
            final int num2 = pointer2 == null ? 0 : pointer2.val;
            int rCurrent = num1 + num2 + carry;
            if (rCurrent >= 10) {
                carry = 1;
                pointerR.next = new ListNode(rCurrent - 10);
            } else {
                carry = 0;
                pointerR.next = new ListNode(rCurrent);
            }

            pointerR = pointerR.next;
            if (pointer1 != null) { pointer1 = pointer1.next; }
            if (pointer2 != null) { pointer2 = pointer2.next; }
        }

        if (carry == 1) {
            pointerR.next = new ListNode(1);
        }

        return r0.next;
    }
}
