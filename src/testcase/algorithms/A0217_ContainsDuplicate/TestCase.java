package testcase.algorithms.A0217_ContainsDuplicate;


import problems.algorithms.A0217_ContainsDuplicate.Solution;

import java.util.Arrays;

/**
 * A0217_ContainsDuplicate
 *
 * @author ml3426
 * @date 2020/12/13
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 1}, true);
        test(new int[]{1, 2, 3, 4}, false);
        test(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true);
    }

    private static void test(int[] nums, boolean expectedResult) {
        final Solution solution = new Solution();
        final boolean actualResult = solution.containsDuplicate1(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
