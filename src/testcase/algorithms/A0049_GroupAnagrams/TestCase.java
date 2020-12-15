package testcase.algorithms.A0049_GroupAnagrams;

import problems.algorithms.A0049_GroupAnagrams.Solution;
import testcase.utils.ParseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * A0049_GroupAnagrams
 *
 * @author ml3426
 * @date 2020/12/14
 */
public class TestCase {

    public static void main(String[] args) {
        test(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}, new String[][] {{"ate","eat","tea"}, {"nat","tan"}, {"bat"}});
    }

    public static void test(String[] strs, String[][] expectedResult) {
        final List<List<String>> actualValue = new Solution().groupAnagrams2(strs);
        System.out.println(String.format("param is %s, ", Arrays.toString(strs)) +
                (ParseUtils.parse2DListToSet(actualValue).equals(ParseUtils.parse2DArrayToSet(expectedResult)) ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", ParseUtils.parse2DArrayToSet(expectedResult), actualValue)));
    }
}
