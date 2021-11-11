package testcase.algorithms.A0704_BinarySearch;


import problems.algorithms.A0704_BinarySearch.Solution;

import java.util.Arrays;

/**
 * A0704_BinarySearch
 *
 * @author reparo
 * @date 2021/11/11
 */
public class TestCase {

    public static void main(String[] args) {
//        test(new int[]{}, 0, -1);
        test(new int[]{5}, 5, 0);
//        test(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4);
//        test(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1);
    }

    public static void test(final int[] nums, final int target, final int expectedResult) {
        final int actualValue = new Solution().search(nums, target);
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
}
