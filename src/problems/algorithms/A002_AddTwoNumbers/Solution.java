package problems.algorithms.A002_AddTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author steven.zmj
 * @date 2020/04/21
 */
public class Solution {

    /**
     * Solution 1: Elementary Math, be careful of the carry
     * Use fake startNode to simplify the code, the real start node is <code>startNode.next</code>
     *
     * Time complexity : O(Max(m, n)).
     * Space complexity : O(Max(m, n)).
     *
     * For reference only:
     * Runtime: 1 ms, 100.00%
     * Memory Usage: 39.7 MB, 99.69%
     *
     * Failed test case: [5][5]
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode startNode = new ListNode(0);
        ListNode currNode = startNode;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int curr = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            if (curr >= 10) {
                carry = 1;
                curr = curr - 10;
            } else {
                carry = 0;
            }

            currNode.next = new ListNode(curr);
            currNode = currNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            currNode.next = new ListNode(1);
        }
        return startNode.next;
    }
}
