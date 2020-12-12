package testcase.algorithms.A0649_Dota2Senate;

import problems.algorithms.A0649_Dota2Senate.Solution;

/**
 * A0649_Dota2Senate
 *
 * @author ml3426
 * @date 2020/12/13
 */
public class TestCase {

    public static void main(String[] args) {
        test("RD", "Radiant");
        test("RDD", "Dire");
        test("DDRRR", "Dire");
        test("RRDDD", "Radiant");
    }

    public static void test(String senate, String expectedResult) {
        final String actualValue = new Solution().predictPartyVictory(senate);
        System.out.println(String.format("param is %s, ", senate) +
                (actualValue.equals(expectedResult) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
