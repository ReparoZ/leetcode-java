package testcase.algorithms.A0190_ReverseBits;

import problems.algorithms.A0190_ReverseBits.Solution;

/**
 * A0190_ReverseBits
 *
 * @author reparo
 * @date 2021/11/25
 */
public class TestCase {

    public static void main(String[] args) {
        test(0b00000010100101000001111010011100, 0b00111001011110000010100101000000);
        test(0b11111111111111111111111111111101, 0b10111111111111111111111111111111);
    }

    private static void test(int n, int expectedResult) {
        final int actualValue = new Solution().reverseBits(n);
        System.out.println(String.format("param is %s", Integer.toBinaryString(n)) +
                (actualValue == expectedResult ? String.format(", result is %s, correct!", Integer.toBinaryString(actualValue)) :
                        String.format(", expectedResult is %s, actualValue is %s, failed", Integer.toBinaryString(expectedResult), Integer.toBinaryString(actualValue))));
    }
}
