package testcase.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Description
 *
 * @author ml3426
 * @date 2020/12/07
 */
public class ParseUtils {

    public static List<Integer> parseArray(int[] expectedResult) {
        final List<Integer> result = new ArrayList<>();

        for (int ints : expectedResult) {
            result.add(ints);
        }

        return result;
    }

    public static List<List<Integer>> parse2DArray(int[][] expectedResult) {
        final List<List<Integer>> result = new ArrayList<>();

        for (int[] ints : expectedResult) {
            result.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
        }

        return result;
    }
}
