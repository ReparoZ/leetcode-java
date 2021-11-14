package problems.algorithms.A0876_MiddleOfTheLinkedList;

/**
 * @author reparo
 * @date 2021/11/14
 */
public class ListNode {

    public int val;

    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
