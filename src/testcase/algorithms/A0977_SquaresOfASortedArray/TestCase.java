package testcase.algorithms.A0977_SquaresOfASortedArray;

import problems.algorithms.A0977_SquaresOfASortedArray.Solution;

import java.util.Arrays;

/**
 * A0977_SquaresOfASortedArray
 *
 * @author reparo
 * @date 2021/11/12
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{0}, new int[]{0});
        test(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100});
        test(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121});
    }

    public static void test(final int[] nums, final int[] expectedResult) {
        final int[] actualValue = new Solution().sortedSquares(nums);
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (Arrays.equals(actualValue, expectedResult) ? String.format("result is %s, correct!", Arrays.toString(actualValue)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", Arrays.toString(expectedResult), Arrays.toString(actualValue))));
    }
}
