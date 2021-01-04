package testcase.algorithms.A0830_PositionsOfLargeGroups;

import problems.algorithms.A0830_PositionsOfLargeGroups.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * A0830_PositionsOfLargeGroups
 *
 * @author ml3426
 * @date 2021/01/05
 */
public class TestCase {

    public static void main(String[] args) {
        test("abbxxxxzzy", List.of(List.of(3, 6)));
        test("abc", new ArrayList<>());
        test("abcdddeeeeaabbbcd", List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14)));
        test("aba", new ArrayList<>());
        test("aaa", List.of(List.of(0, 2)));
    }

    public static void test(String str, List<List<Integer>> expectedResult) {
        final List<List<Integer>> actualValue = new Solution().largeGroupPositions(str);
        System.out.println(String.format("param is %s, ", str) +
                (actualValue.equals(expectedResult) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
