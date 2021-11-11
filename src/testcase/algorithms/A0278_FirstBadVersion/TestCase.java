package testcase.algorithms.A0278_FirstBadVersion;

import problems.algorithms.A0278_FirstBadVersion.Solution;
import problems.algorithms.A0278_FirstBadVersion.VersionControl;

import java.util.Arrays;

/**
 * A0278_FirstBadVersion
 *
 * @author reparo
 * @date 2021/11/11
 */
public class TestCase {

    public static void main(String[] args) {
        test(1, 1);
        test(2, 1);
        test(5, 1);
        test(5, 2);
        test(5, 3);
        test(5, 4);
        test(5, 5);
        test(6, 1);
        test(6, 2);
        test(6, 3);
        test(6, 4);
        test(6, 5);
        test(6, 6);
        test(2126753390, 1702766719);
    }

    private static void test(int n, int expectedResult) {
        VersionControl.badVersionIndex = expectedResult;
        final int actualValue = new Solution().firstBadVersion(n);
        System.out.println(String.format("param is %s, bad is %s", n, expectedResult) +
                (actualValue == expectedResult ? String.format(", result is %s, correct!", actualValue) :
                        String.format(", expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
