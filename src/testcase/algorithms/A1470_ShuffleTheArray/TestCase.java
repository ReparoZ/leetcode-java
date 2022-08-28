package testcase.algorithms.A1470_ShuffleTheArray;

import problems.algorithms.A1470_ShuffleTheArray.Solution;

import java.util.Arrays;

/**
 * A1470_ShuffleTheArray
 *
 * @author reparo
 * @date 2021/11/20
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{2, 5, 1, 3, 4, 7}, 3, new int[]{2, 3, 5, 4, 1, 7});
        test(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4, new int[]{1, 4, 2, 3, 3, 2, 4, 1});
        test(new int[]{1, 1, 2, 2}, 2, new int[]{1, 2, 1, 2});
        test(new int[]{1, 1, 2, 2}, 3, new int[]{1, 2, 1, 2});
        test(new int[]{1, 1, 2, 2}, 0, new int[]{1, 1, 2, 2});
    }

    private static void test(int[] nums, int target, int[] expectedResult) {
        final Solution solution = new Solution();
        final int[] actualResult = solution.shuffle(nums, target);
        System.out.println(String.format("param1: %s, param2: %s, ", Arrays.toString(nums), target) + (Arrays.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", Arrays.toString(actualResult)) : String.format("Failed! expectedResult is %s, actualResult is %s.", Arrays.toString(expectedResult), Arrays.toString(actualResult))));
    }
}
