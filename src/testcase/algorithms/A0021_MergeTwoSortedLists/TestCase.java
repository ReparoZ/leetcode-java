package testcase.algorithms.A0021_MergeTwoSortedLists;

import problems.algorithms.A0021_MergeTwoSortedLists.ListNode;
import problems.algorithms.A0021_MergeTwoSortedLists.Solution;

/**
 * A0021_MergeTwoSortedLists
 *
 * @author reparo
 * @date 2021/11/20
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4});
        test(new int[]{}, new int[]{}, new int[]{});
        test(new int[]{}, new int[]{0}, new int[]{0});
    }

    public static void test(int[] nums, int[] numsb, int[] expectedResult) {
        final ListNode headNode = genListNode(nums);
        final String params1 = parseListNode(headNode);
        final ListNode headNode2 = genListNode(numsb);
        final String params2 = parseListNode(headNode2);
        final ListNode node = new Solution().mergeTwoLists(headNode, headNode2);
        final String result = parseListNode(node);
        final String expectedStr = parseListNode(genListNode(expectedResult));

        System.out.println(String.format("param1 is %s, param2 is %s, ", params1, params2) +
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
