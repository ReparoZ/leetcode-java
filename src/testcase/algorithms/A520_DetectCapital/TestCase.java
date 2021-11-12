package testcase.algorithms.A520_DetectCapital;

import problems.algorithms.A520_DetectCapital.Solution;

import java.util.Arrays;

/**
 * A520_DetectCapital
 *
 * @author reparo
 * @date 2021/11/13
 */
public class TestCase {

    public static void main(String[] args) {
        test("USA", true);
        test("leetcode", true);
        test("Google", true);
        test("FlaG", false);
        test("fLAG", false);
    }

    private static void test(String word, boolean expectedResult) {
        final Solution solution = new Solution();
        final boolean actualResult = solution.detectCapitalUse(word);
        System.out.println(String.format("param1: %s, ", word) + (actualResult == expectedResult ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
