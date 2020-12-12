package testcase.algorithms.A0860_LemonadeChange;


import problems.algorithms.A0860_LemonadeChange.Solution;

import java.util.Arrays;

/**
 * A0860_LemonadeChange
 *
 * @author ml3426
 * @date 2020/12/13
 */
public class TestCase {

    public static void main(String[] args) {
//        test(new int[]{5, 5, 5, 10, 20}, true);
//        test(new int[]{5, 5, 10}, true);
//        test(new int[]{10, 10}, false);
//        test(new int[]{5, 5, 10, 10, 20}, false);
        test(new int[]{5, 5, 5, 5, 10, 5, 10, 10, 10, 20}, true);
    }

    private static void test(int[] nums, boolean expectedResult) {
        final Solution solution = new Solution();
        final boolean actualResult = solution.lemonadeChange(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
