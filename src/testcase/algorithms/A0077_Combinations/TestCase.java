package testcase.algorithms.A0077_Combinations;

import problems.algorithms.A0077_Combinations.Solution;
import testcase.utils.ParseUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A0077_Combinations
 *
 * @author reparo
 * @date 2021/11/21
 */
public class TestCase {

    public static void main(String[] args) {
        test(4, 2, ParseUtils.parse2DArrayToSet(new Integer[][]{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}}));
        test(1, 1, ParseUtils.parse2DArrayToSet(new Integer[][]{{1}}));
    }

    private static void test(int n, int k, final Set<Set<Integer>> expectedResult) {
        final List<List<Integer>> combine = new Solution().combine(n, k);
        final Set<Set<Integer>> combineSets = combine.stream().map(HashSet::new).collect(Collectors.toSet());
        System.out.println(String.format("param1: %s, param2: %s, ", n, k) + (expectedResult.equals(combineSets) ?
                String.format("correct! result is %s", combineSets) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, combineSets)));
    }
}
