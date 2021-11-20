package testcase.algorithms.A0206_ReverseLinkedList;

import problems.algorithms.A0206_ReverseLinkedList.ListNode;
import problems.algorithms.A0206_ReverseLinkedList.Solution;

import java.util.Arrays;

/**
 * A0206_ReverseLinkedList
 *
 * @author reparo
 * @date 2021/11/21
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5}, "54321");
        test(new int[]{1, 2}, "12");
        test(new int[]{}, "");
    }

    public static void test(int[] nums, String expectedResult) {
        final ListNode listNode = new Solution().reverseList(genListNode(nums));
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (parseListNode(listNode).equals(expectedResult) ? String.format("result is %s, correct!", parseListNode(listNode)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, parseListNode(listNode))));
    }

    private static ListNode genListNode(final int[] input) {
        final ListNode startNode = new ListNode(0, null);
        ListNode currNode = startNode;

        for (final int j : input) {
            currNode.next = new ListNode(j, null);
            currNode = currNode.next;
        }

        return startNode.next;
    }

    public static String parseListNode(ListNode node) {
        final StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            node = node.next;
        }

        return builder.toString();
    }
}
