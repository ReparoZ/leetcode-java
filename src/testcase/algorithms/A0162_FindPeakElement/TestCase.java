package testcase.algorithms.A0162_FindPeakElement;

import problems.algorithms.A0162_FindPeakElement.Solution;

import java.util.Arrays;

/**
 * A0162_FindPeakElement
 *
 * @author reparo
 * @date 2021/12/4
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 1}, 2);
        test(new int[]{1, 2, 1, 3, 5, 6, 4}, 5);
    }

    private static void test(int[] nums, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.findPeakElement(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
