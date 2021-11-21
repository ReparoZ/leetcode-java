package testcase.algorithms.A0046_Permutations;

import problems.algorithms.A0046_Permutations.Solution;
import testcase.utils.ParseUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A0046_Permutations
 *
 * @author reparo
 * @date 2021/11/21
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3}, ParseUtils.parse2DIntArrayToOuterSet(new int[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}}));
    }

    private static void test(int[] nums, final Set<List<Integer>> expectedResult) {
        final List<List<Integer>> combine = new Solution().permute(nums);
        final Set<List<Integer>> combineSets = new HashSet<>(combine);
        System.out.println(String.format("param: %s, ", Arrays.toString(nums)) + (expectedResult.equals(combineSets) ?
                String.format("correct! result is %s", combineSets) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, combineSets)));
    }
}
