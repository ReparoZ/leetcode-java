package problems.algorithms.A0019_RemoveNthNodeFromEndOfList;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * 
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/11/15
 */
public class Solution {

    /**
     * 找到倒数第N，用两个指针，一个领先另一个N步，当领先的那个走到终点时，第一个就到了第N位，再替换即可
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 36.3 MB, 67.35%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforeNode = new ListNode(0, head);
        ListNode behindHead = new ListNode(0, head);
        ListNode beforeHead = beforeNode;

        for (int i = 0; i < n; i++) {
            behindHead = behindHead.next;
        }

        while (behindHead.next != null) {
            beforeNode = beforeNode.next;
            behindHead = behindHead.next;
        }

        beforeNode.next = beforeNode.next.next;
        return beforeHead.next;
    }
}
