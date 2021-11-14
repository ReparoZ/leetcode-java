package problems.algorithms.A0876_MiddleOfTheLinkedList;

/**
 * 给定一个头结点为 head的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * 提示：
 *
 * 给定链表的结点数介于1和100之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/14
 */
public class Solution {

    /**
     * 找到中点，用两个指针，一个每次往前一步，一个每次往前两步，就能找到中点
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 35.9 MB, 49.41%
     */
    public ListNode middleNode(ListNode head) {
        ListNode oneStepHead = new ListNode(0, head);
        ListNode twoStepHead = new ListNode(0, head);

        while (twoStepHead != null) {
            oneStepHead = oneStepHead.next;
            twoStepHead = twoStepHead.next == null ? twoStepHead.next : twoStepHead.next.next;
        }

        return oneStepHead;
    }
}
