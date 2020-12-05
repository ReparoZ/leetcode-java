package testcase.algorithms.A0004_MedianofTwoSortedArrays;

import java.util.Arrays;

import problems.algorithms.A0004_MedianofTwoSortedArrays.Solution;

/**
 * A004_MedianofTwoSortedArrays
 *
 * @author steven.zmj
 * @date 2020/12/05
 */
public class TestCase {

    public static void main(String[] args) {
        test(buildArr(1, 3), buildArr(2), 2.0);
        test(buildArr(2), buildArr(1), 1.5);
        test(buildArr(1, 3), buildArr(2, 4), 2.5);
        test(buildArr(1, 2, 3), buildArr(), 2.0);
        test(buildArr(3, 3, 3), buildArr(3, 3), 3.0);
    }
    
    private static void test(int[] arr1, int[] arr2, double expectedResult) {
        final Solution solution = new Solution();
        final double actualValue = solution.findMedianSortedArrays2(arr1, arr2);
        System.out.println(String.format("param is %s, %s, ", Arrays.toString(arr1), Arrays.toString(arr2)) +
                (actualValue == expectedResult ? String.format("result is %s, correct!", actualValue) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualValue)));
    }
    
    private static int[] buildArr(Integer... num) {
        final int[] ints = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            ints[i] = num[i];
        }
        return ints;
    }
}
