package testcase.algorithms.A0198_HouseRobber;

import problems.algorithms.A0198_HouseRobber.Solution;

import java.util.Arrays;

/**
 * A0198_HouseRobber
 *
 * @author reparo
 * @date 2021/11/23
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 1}, 4);
        test(new int[]{2, 7, 9, 3, 1}, 12);
    }

    private static void test(int[] nums, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.rob(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
