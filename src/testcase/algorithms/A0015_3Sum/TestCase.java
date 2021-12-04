package testcase.algorithms.A0015_3Sum;

import problems.algorithms.A0015_3Sum.Solution;
import testcase.utils.ParseUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * A0015_3Sum
 *
 * @author reparo
 * @date 2021/12/5
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{}, new int[][]{{}});
        test(new int[]{0}, new int[][]{{}});
        test(new int[]{-3, -2, -1, 4, 5}, new int[][]{{-3, -2, 5}, {-3, -1, 4}});
        test(new int[]{-1, 0, 1, 2, -1, -4}, new int[][]{{-1, -1, 2}, {-1, 0, 1}});
    }

    public static void test(int[] nums, int[][] expectedResult) {
        final List<List<Integer>> actualResult = new Solution().threeSum(nums);
        final Set<Set<Integer>> expectedResultSet = ParseUtils.parse2DIntArrayToSet(expectedResult);
        final Set<Set<Integer>> actualResultSet = ParseUtils.parse2DListToSet(actualResult);
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (expectedResultSet.equals(actualResultSet) ? String.format("result is %s, correct!", expectedResultSet) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResultSet, actualResult)));
    }
}
