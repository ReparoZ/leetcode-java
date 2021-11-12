package testcase.algorithms.A0283_MoveZeroes;

import problems.algorithms.A0283_MoveZeroes.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0283_MoveZeroes
 *
 * @author reparo
 * @date 2021/11/13
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{0}, new int[]{0});
        test(new int[]{1}, new int[]{1});
        test(new int[]{0, 0, 0, 1, 2}, new int[]{1, 2, 0, 0, 0});
        test(new int[]{1, 2, 0, 1, 2}, new int[]{1, 2, 1, 2, 0});
        test(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0});
        test(new int[]{45192, 0, -659, -52359, -99225, -75991, 0, -15155, 27382, 59818, 0, -30645, -17025, 81209, 887, 64648}, new int[]{45192, -659, -52359, -99225, -75991, -15155, 27382, 59818, -30645, -17025, 81209, 887, 64648, 0, 0, 0});
    }

    public static void test(int[] nums, int[] expectedResult) {
        final List<Integer> originNums = ParseUtils.parseArray(nums);
        new Solution().moveZeroes(nums);
        System.out.println(String.format("param is %s, ", originNums) +
                (ParseUtils.parseArray(nums).equals(ParseUtils.parseArray(expectedResult)) ? String.format("result is %s, correct!", ParseUtils.parseArray(nums)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", ParseUtils.parseArray(expectedResult), ParseUtils.parseArray(nums))));
    }
}
