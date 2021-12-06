package testcase.algorithms.A0844_BackspaceStringCompare;

import problems.algorithms.A0844_BackspaceStringCompare.Solution;

import java.util.Objects;

/**
 * A0844_BackspaceStringCompare
 *
 * @author reparo
 * @date 2021/12/7
 */
public class TestCase {

    public static void main(String[] args) {
        test("ab#c", "ad#c", true);
        test("ab##", "c#d#", true);
        test("a##c", "#a#c", true);
        test("a#c", "b", false);
        test("xywrrmp", "xywrrmu#p", true);
        test("bxj##tw", "bxo#j##tw", true);
        test("bxj##tw", "bxj###tw", false);
        test("aaa###a", "aaaa###a", false);
    }

    private static void test(String a, String b, boolean expectedResult) {
        final Solution solution = new Solution();
        final boolean actualResult = solution.backspaceCompare(a, b);
        System.out.println(String.format("param1: %s, param2: %s, ", a, b) + (Objects.equals(expectedResult, actualResult) ?
                String.format("correct! result is %s", actualResult) : String.format("Failed! expectedResult is %s, actualResult is %s.", expectedResult, actualResult)));
    }
}
