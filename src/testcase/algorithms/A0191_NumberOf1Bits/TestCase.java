package testcase.algorithms.A0191_NumberOf1Bits;

import problems.algorithms.A0191_NumberOf1Bits.Solution;

/**
 * A0191_NumberOf1Bits
 *
 * @author reparo
 * @date 2021/11/24
 */
public class TestCase {

    public static void main(String[] args) {
        test(0b00000000000000000000000000001011, 3);
        test(0b00000000000000000000000010000000, 1);
        test(0b11111111111111111111111111111101, 31);
    }

    public static void test(int n, int expectedResult) {
        final int actualValue = new Solution().hammingWeight(n);
        System.out.println(String.format("param is %s, ", n) +
                (actualValue== expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
