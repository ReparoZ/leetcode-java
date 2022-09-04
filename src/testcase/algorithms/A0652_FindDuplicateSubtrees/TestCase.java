package testcase.algorithms.A0652_FindDuplicateSubtrees;

import problems.algorithms.A0652_FindDuplicateSubtrees.Solution;
import problems.algorithms.A0652_FindDuplicateSubtrees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A0652_FindDuplicateSubtrees
 *
 * @author reparo
 * @date 2022/9/5
 */
public class TestCase {

    public static void main(String[] args) {
        test(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4}, new Integer[][]{{2, 4}, {4}});
        test(new Integer[]{2, 1, 1}, new Integer[][]{{1}});
        test(new Integer[]{2, 2, 2, 3, null, 3, null}, new Integer[][]{{2, 3}, {3}});
    }

    public static void test(Integer[] root, Integer[][] expectedResult) {
        final List<TreeNode> actualValue = new Solution().findDuplicateSubtrees(buildATree(root));
        final Set<String> actualSet = actualValue.stream().map(TestCase::parseTree).map(Arrays::toString).collect(Collectors.toSet());
        final Set<String> expectedSet = Arrays.stream(expectedResult).map(Arrays::toString).collect(Collectors.toSet());
        System.out.println(String.format("param is %s, ", Arrays.toString(root)) +
                (actualSet.equals(expectedSet) ? String.format("result is %s, correct!", actualSet) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedSet, actualSet)));
    }

    public static TreeNode buildATree(final Integer[] treeArray) {
        int rows = 0, col = 0, isLeft = 1;
        final List<List<TreeNode>> treeRows = new ArrayList<>();
        treeRows.add(new ArrayList<>());
        TreeNode root = new TreeNode(0);
        for (final Integer j : treeArray) {
            if (rows == 0) {
                root = new TreeNode(treeArray[0]);
                treeRows.get(rows).add(root);
            } else {
                final TreeNode thisParentNode = treeRows.get(rows - 1).get(col);
                final TreeNode thisNode = j == null ? null : new TreeNode(j);
                if (thisNode != null) {
                    treeRows.get(rows).add(thisNode);
                }
                if (isLeft == 1) {
                    thisParentNode.left = thisNode;
                    isLeft = 2;
                } else {
                    thisParentNode.right = thisNode;
                    isLeft = 1;
                    col++;
                }
            }

            if (rows == 0 || col == treeRows.get(rows - 1).size()) {
                rows++;
                treeRows.add(new ArrayList<>());
                col = 0;
            }
        }

        return root;
    }

    public static Integer[] parseTree(final TreeNode rootNode) {
        final Queue<TreeNode> deque = new LinkedList<>();
        final ArrayList<Integer> ints = new ArrayList<>();
        deque.add(rootNode);

        while (!deque.isEmpty() && !deque.stream().allMatch(Objects::isNull)) {
            final TreeNode node = deque.poll();
            ints.add(node == null ? null : node.val);
            if (node != null) {
                deque.add(node.left);
                deque.add(node.right);
            }
        }

        return ints.toArray(new Integer[]{});
    }
}
