package testcase.algorithms.A0136_SingleNumber;

import problems.algorithms.A0136_SingleNumber.Solution;

import java.util.Arrays;

/**
 * A0136_SingleNumber
 *
 * @author reparo
 * @date 2021/11/24
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{2, 2, 1}, 1);
        test(new int[]{4, 1, 2, 1, 2}, 4);
    }

    private static void test(int[] nums, int expectedResult) {
        final Solution solution = new Solution();
        final int actualResult = solution.singleNumber(nums);
        System.out.println(String.format("param1: %s, ", Arrays.toString(nums)) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
