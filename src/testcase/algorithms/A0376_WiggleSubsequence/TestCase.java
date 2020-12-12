package testcase.algorithms.A0376_WiggleSubsequence;


import problems.algorithms.A0376_WiggleSubsequence.Solution;

import java.util.Arrays;

/**
 * A0376_WiggleSubsequence
 *
 * @author ml3426
 * @date 2020/12/13
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{}, 0);
        test(new int[]{1}, 1);
        test(new int[]{0, 0}, 1);
        test(new int[]{1, 2, 1, 3, 2}, 5);
        test(new int[]{20, 238, 238, 89}, 3);
        test(new int[]{1, 7, 4, 9, 2, 5}, 6);
        test(new int[]{1, 1, 7, 4, 9, 2, 5}, 6);
        test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
        test(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7);
        test(new int[]{98, 285, 312, 312, 365, 415, 367, 105}, 3);
        test(new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1, 3, 3, 3, 2, 2, 2}, 5);
        test(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15}, 67);
    }

    private static void test(int[] nums, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.wiggleMaxLength2(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
