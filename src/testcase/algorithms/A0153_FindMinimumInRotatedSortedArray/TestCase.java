package testcase.algorithms.A0153_FindMinimumInRotatedSortedArray;

import problems.algorithms.A0153_FindMinimumInRotatedSortedArray.Solution;

import java.util.Arrays;

/**
 * A0153_FindMinimumInRotatedSortedArray
 *
 * @author reparo
 * @date 2021/12/4
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{3, 1, 2}, 1);
        test(new int[]{5, 1, 2, 3, 4}, 1);
        test(new int[]{3, 4, 5, 1, 2}, 1);
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        test(new int[]{11, 13, 15, 17}, 11);
    }

    private static void test(int[] nums, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.findMin(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
