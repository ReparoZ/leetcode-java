package testcase.algorithms.A0006_ZigzagConversion;

import problems.algorithms.A0006_ZigzagConversion.Solution;

import java.util.Arrays;

/**
 * A0006_ZigzagConversion
 *
 * @author ml3426
 * @date 2020/12/08
 */
public class TestCase {

    public static void main(String[] args) {
        test("A", 1, "A");
        test("LEETCODEISHIRING", 3, "LCIRETOESIIGEDHN");
        test("LEETCODEISHIRING", 4, "LDREOEIIECIHNTSG");
    }

    private static void test(String s, int rowNum, String expectedResult) {
        final Solution solution = new Solution();
        final String actualResult = solution.convert(s, rowNum);
        System.out.println(String.format("param1: %s, param2: %s, ", s, rowNum) + (actualResult.equals(expectedResult) ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", actualResult, expectedResult)));
    }
}
