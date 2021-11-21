package testcase.algorithms.A0784_LetterCasePermutation;

import problems.algorithms.A0784_LetterCasePermutation.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A0784_LetterCasePermutation
 *
 * @author reparo
 * @date 2021/11/21
 */
public class TestCase {

    public static void main(String[] args) {
        test("a1b2", Set.of("a1b2", "a1B2", "A1b2", "A1B2"));
        test("3z4", Set.of("3z4", "3Z4"));
        test("12345", Set.of("12345"));
    }

    private static void test(String s, final Set<String> expectedResult) {
        final List<String> combine = new Solution().letterCasePermutation(s);
        final Set<String> combineSets = new HashSet<>(combine);
        System.out.println(String.format("param: %s, ", s) + (expectedResult.equals(combineSets) ?
                String.format("correct! result is %s", combineSets) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, combineSets)));
    }
}
