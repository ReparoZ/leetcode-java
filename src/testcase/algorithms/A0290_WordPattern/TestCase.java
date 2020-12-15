package testcase.algorithms.A0290_WordPattern;

import problems.algorithms.A0290_WordPattern.Solution;

/**
 * A0290_WordPattern
 *
 * @author ml3426
 * @date 2020/12/16
 */
public class TestCase {

    public static void main(String[] args) {
        test("abba", "dog cat cat dog", true);
        test("abba", "dog cat cat fish", false);
        test("aaaa", "dog cat cat dog", false);
        test("abba", "dog dog dog dog", false);
    }

    private static void test(String pattern, String s, boolean expectedResult) {
        final Solution solution = new Solution();
        final boolean actualResult = solution.wordPattern(pattern, s);
        System.out.println(String.format("param1: %s, param2: %s, ", pattern, s) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", actualResult, expectedResult)));
    }
}
