package testcase.algorithms.A0677_MapSumPairs;


import problems.algorithms.A0677_MapSumPairs.MapSum;

/**
 * A0677_MapSumPairs
 *
 * @author reparo
 * @date 2021/11/14
 */
public class TestCase {

    public static void main(String[] args) {
        final MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        final int actualValue1 = mapSum.sum("ap");
        test("ap", actualValue1, 3);
        mapSum.insert("app", 2);
        final int actualValue2 = mapSum.sum("appl");
        test("appl", actualValue2, 3);
        final int actualValue3 = mapSum.sum("app");
        test("app", actualValue3, 5);
    }

    public static void test(final String str, final int actualValue, final int expectedResult) {
        System.out.println(String.format("param is %s, ", str) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
