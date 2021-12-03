package testcase.algorithms.A0033_SearchInRotatedSortedArray;

import problems.algorithms.A0033_SearchInRotatedSortedArray.Solution;

import java.util.Arrays;

/**
 * A0033_SearchInRotatedSortedArray
 *
 * @author reparo
 * @date 2021/12/4
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4);
        test(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1);
        test(new int[]{1}, 0, -1);
    }

    private static void test(int[] nums, int target, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.search(nums, target);
        System.out.println(String.format("param1: %s, target: %s, ", Arrays.toString(nums), target) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
