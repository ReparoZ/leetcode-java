package testcase.algorithms.A0082_RemoveDuplicatesFromSortedListII;

import problems.algorithms.A0082_RemoveDuplicatesFromSortedListII.ListNode;
import problems.algorithms.A0082_RemoveDuplicatesFromSortedListII.Solution;

/**
 * A0082_RemoveDuplicatesFromSortedListII
 *
 * @author reparo
 * @date 2021/12/4
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 3, 4, 4, 5}, new int[]{1, 2, 5});
        test(new int[]{1, 1, 1, 2, 3}, new int[]{2, 3});
    }

    public static void test(int[] nums, int[] expectedResult) {
        final ListNode headNode = genListNode(nums);
        final String params = parseListNode(headNode);
        final ListNode node = new Solution().deleteDuplicates(headNode);
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
