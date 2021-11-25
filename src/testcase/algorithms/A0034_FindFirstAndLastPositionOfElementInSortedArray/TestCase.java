package testcase.algorithms.A0034_FindFirstAndLastPositionOfElementInSortedArray;

import problems.algorithms.A0034_FindFirstAndLastPositionOfElementInSortedArray.Solution;

import java.util.Arrays;

/**
 * A0034_FindFirstAndLastPositionOfElementInSortedArray
 *
 * @author reparo
 * @date 2021/11/26
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4});
        test(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1});
        test(new int[]{}, 0, new int[]{-1, -1});
    }

    private static void test(int[] nums, int target, int[] expectedResult) {
        final Solution solution = new Solution();
        final int[] actualResult = solution.searchRange(nums, target);
        System.out.println(String.format("param1: %s, param2: %s, ", Arrays.toString(nums), target) + (Arrays.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", Arrays.toString(actualResult)) : String.format("Failed! expectedResult is %s, actualResult is %s.", Arrays.toString(expectedResult), Arrays.toString(actualResult))));
    }
}
