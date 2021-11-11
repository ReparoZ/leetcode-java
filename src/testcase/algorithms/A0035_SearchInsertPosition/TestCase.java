package testcase.algorithms.A0035_SearchInsertPosition;

import problems.algorithms.A0035_SearchInsertPosition.Solution;

import java.util.Arrays;

/**
 * A0035_SearchInsertPosition
 *
 * @author reparo
 * @date 2021/11/12
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{}, 0, 0);
        test(new int[]{5}, 5, 0);
        test(new int[]{1, 3, 5, 6}, 2, 1);
        test(new int[]{1, 3, 5, 6}, 5, 2);
        test(new int[]{1, 3, 5, 6}, 7, 4);
        test(new int[]{1, 3, 5, 6}, 0, 0);
        test(new int[]{1}, 0, 0);
    }

    public static void test(final int[] nums, final int target, final int expectedResult) {
        final int actualValue = new Solution().searchInsert(nums, target);
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
