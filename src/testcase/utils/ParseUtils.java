package testcase.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 解析工具类
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

    public static List<Character> parseArray(char[] expectedResult) {
        final List<Character> result = new ArrayList<>();

        for (char ints : expectedResult) {
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

    public static List<List<Character>> parse2DArray(char[][] expectedResult) {
        final List<List<Character>> result = new ArrayList<>();

        for (char[] chars : expectedResult) {
            final List<Character> innerResult = new ArrayList<>();
            for (char aChar : chars) {
                innerResult.add(aChar);
            }
            result.add(innerResult);
        }

        return result;
    }

    public static <T> Set<Set<T>> parse2DArrayToSet(T[][] expectedResult) {
        final Set<Set<T>> result = new HashSet<>();

        for (T[] ints : expectedResult) {
            final Set<T> inner = new HashSet<>(Arrays.asList(ints));
            result.add(inner);
        }

        return result;
    }

    public static <T> Set<Set<T>> parse2DListToSet(List<List<T>> expectedResult) {
        final Set<Set<T>> result = new HashSet<>();

        for (List<T> ts : expectedResult) {
            result.add(new HashSet<>(ts));
        }

        return result;
    }

    public static Set<List<Integer>> parse2DIntArrayToOuterSet(int[][] expectedResult) {
        return new HashSet<>(parse2DArray(expectedResult));
    }

    public static Set<Set<Integer>> parse2DIntArrayToSet(int[][] expectedResult) {
        return parse2DArray(expectedResult).stream()
                .map(HashSet::new)
                .collect(Collectors.toSet());
    }
}
