package testcase.algorithms.A0557_ReverseWordsInAStringIII;

import problems.algorithms.A0557_ReverseWordsInAStringIII.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0557_ReverseWordsInAStringIII
 *
 * @author reparo
 * @date 2021/11/14
 */
public class TestCase {

    public static void main(String[] args) {
        test("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc");
        test("God Ding", "doG gniD");
    }

    public static void test(String s, String expectedResult) {
        final String actualValue = new Solution().reverseWords(s);
        System.out.println(String.format("param is \"%s\", ", s) +
                (actualValue.equals(expectedResult) ? String.format("result is \"%s\", correct!", actualValue) :
                        String.format("expectedResult is \"%s\", actualValue is \"%s\", failed", expectedResult, actualValue)));
    }
}