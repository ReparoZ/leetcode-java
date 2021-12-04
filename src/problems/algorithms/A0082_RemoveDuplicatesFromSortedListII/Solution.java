package problems.algorithms.A0082_RemoveDuplicatesFromSortedListII;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 
 *
 * 示例 1：
 * https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * https://assets.leetcode.com/uploads/2021/01/04/linkedlist2.jpg
 *
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/12/4
 */
public class Solution {

    /**
     * 从头循环到尾，每次遇到一个重复数字，开启新循环跳过所有的重复数字
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 37.9 MB, 45.94%
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        final ListNode dummyNode = new ListNode(0, head);
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                int dupNum = curNode.next.val;
                while (curNode.next != null && curNode.next.val == dupNum) {
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }

        return dummyNode.next;
    }
}
