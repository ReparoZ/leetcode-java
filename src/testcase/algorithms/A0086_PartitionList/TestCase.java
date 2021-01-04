package testcase.algorithms.A0086_PartitionList;

import problems.algorithms.A0086_PartitionList.ListNode;
import problems.algorithms.A0086_PartitionList.Solution;

import java.util.Objects;

/**
 * Class Description
 *
 * @author ml3426
 * @date 2021/01/04
 */
public class TestCase {

    public static void main(String[] args) {
        test("143252", 3, "122435");
    }

    private static void test(String a, int b, String expectedResult) {
        final Solution solution = new Solution();
        final ListNode listNode = solution.partition(genListNode(a), b);
        final String actualResult = parseListNode(listNode);
        System.out.println(String.format("param1: %s, param2: %s, ", a, b) + (Objects.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }

    private static ListNode genListNode(String input) {
        final ListNode startNode = new ListNode(0);
        ListNode currNode = startNode;

        for (int i = 0; i < input.length(); i++) {
            currNode.next = new ListNode(Character.getNumericValue(input.charAt(i)));
            currNode = currNode.next;
        }

        return startNode.next;
    }

    private static String parseListNode(ListNode input) {
        final StringBuilder sb = new StringBuilder();
        while (input != null) {
            sb.append(input.val);
            input = input.next;
        }
        return sb.toString();
    }
}
