package testcase.algorithms.A0318_MaximumProductOfWordLengths;

import problems.algorithms.A0318_MaximumProductOfWordLengths.Solution;

import java.util.Arrays;

/**
 * A0318_MaximumProductOfWordLengths
 *
 * @author reparo
 * @date 2021/11/17
 */
public class TestCase {

    public static void main(String[] args) {
        test(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16);
        test(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4);
        test(new String[]{"a", "aa", "aaa", "aaaa"}, 0);
    }

    public static void test(final String[] words, int expectedResult) {
        final int actualValue = new Solution().maxProduct(words);
        System.out.println(String.format("param is %s, ", Arrays.toString(words)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
