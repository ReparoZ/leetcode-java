package testcase.algorithms.A0001_TwoSum;



import problems.algorithms.A0001_TwoSum.Solution;

import java.util.Arrays;

/**
 * A002_AddTwoNumbers
 *
 * @author steven.zmj
 * @date 2020/12/01
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1});
        test(new int[] {3, 2, 4}, 6, new int[] {1, 2});
        test(new int[] {3, 3}, 6, new int[] {0, 1});
    }

    private static void test(int[] nums, int target, int[] expectedResult) {
        final Solution solution = new Solution();
        final int[] actualResult = solution.twoSum(nums, target);
        System.out.println(String.format("param1: %s, param2: %s, ", Arrays.toString(nums), target) + (Arrays.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", Arrays.toString(actualResult)) : String.format("Failed! expectedResult is %s, actualResult is %s.", Arrays.toString(actualResult), Arrays.toString(expectedResult))));
    }
}
