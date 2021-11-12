package testcase.algorithms.A0167_TwoSumIIInputArrayIsSorted;

import problems.algorithms.A0167_TwoSumIIInputArrayIsSorted.Solution;

import java.util.Arrays;

/**
 * A0167_TwoSumIIInputArrayIsSorted
 *
 * @author reparo
 * @date 2021/11/13
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8, new int[]{4, 5});
        test(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2});
        test(new int[]{2, 3, 4}, 6, new int[]{1, 3});
        test(new int[]{-1, 0}, -1, new int[]{1, 2});
    }

    private static void test(int[] nums, int target, int[] expectedResult) {
        final Solution solution = new Solution();
        final int[] actualResult = solution.twoSum(nums, target);
        System.out.println(String.format("param1: %s, param2: %s, ", Arrays.toString(nums), target) + (Arrays.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", Arrays.toString(actualResult)) : String.format("Failed! expectedResult is %s, actualResult is %s.", Arrays.toString(expectedResult), Arrays.toString(actualResult))));
    }
}
