package testcase.algorithms.A0019_RemoveNthNodeFromEndOfList;

import problems.algorithms.A0019_RemoveNthNodeFromEndOfList.ListNode;
import problems.algorithms.A0019_RemoveNthNodeFromEndOfList.Solution;

/**
 * A0019_RemoveNthNodeFromEndOfList
 *
 * @author reparo
 * @date 2021/11/15
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5});
        test(new int[]{1}, 1, new int[]{});
        test(new int[]{1, 2}, 1, new int[]{1});
    }

    public static void test(int[] nums, int k, int[] expectedResult) {
        final ListNode headNode = genListNode(nums);
        final String params = parseListNode(headNode);
        final ListNode node = new Solution().removeNthFromEnd(headNode, k);
        final String result = parseListNode(node);
        final String expectedStr = parseListNode(genListNode(expectedResult));

        System.out.println(String.format("param is %s, ", params) +
                (result.equals(expectedStr) ? String.format("result is %s, correct!", result) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedStr, result)));
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
