package testcase.algorithms.A0189_RotateArray;

import problems.algorithms.A0189_RotateArray.Solution;
import testcase.utils.ParseUtils;

import java.util.List;

/**
 * A0189_RotateArray
 *
 * @author reparo
 * @date 2021/11/12
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 1, new int[]{7, 1, 2, 3, 4, 5, 6});
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, new int[]{6, 7, 1, 2, 3, 4, 5});
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4});
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4});
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 1110, new int[]{4, 5, 6, 7, 1, 2, 3});
        test(new int[]{-1, -100, 3, 99}, 1, new int[]{99, -1, -100, 3});
        test(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100});
    }

    public static void test(int[] nums, int k, int[] expectedResult) {
        final List<Integer> originNums = ParseUtils.parseArray(nums);
        new Solution().rotate(nums, k);
        System.out.println(String.format("param is %s, ", originNums) +
                (ParseUtils.parseArray(nums).equals(ParseUtils.parseArray(expectedResult)) ? String.format("result is %s, correct!", ParseUtils.parseArray(nums)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", ParseUtils.parseArray(expectedResult), ParseUtils.parseArray(nums))));
    }
}
