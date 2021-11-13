package testcase.algorithms.A0344_ReverseString;

import problems.algorithms.A0344_ReverseString.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A344_ReverseString
 *
 * @author reparo
 * @date 2021/11/13
 */
public class TestCase {

    public static void main(String[] args) {
        test(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'});
        test(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }

    public static void test(char[] s, char[] expectedResult) {
        final List<Character> originChars = ParseUtils.parseArray(s);
        new Solution().reverseString(s);
        System.out.println(String.format("param is %s, ", originChars) +
                (ParseUtils.parseArray(s).equals(ParseUtils.parseArray(expectedResult)) ? String.format("result is %s, correct!", ParseUtils.parseArray(s)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", ParseUtils.parseArray(expectedResult), ParseUtils.parseArray(s))));
    }
}
