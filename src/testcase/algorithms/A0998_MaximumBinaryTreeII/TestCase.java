package testcase.algorithms.A0998_MaximumBinaryTreeII;

import problems.algorithms.A0998_MaximumBinaryTreeII.Solution;
import problems.algorithms.A0998_MaximumBinaryTreeII.TreeNode;

import java.util.*;

/**
 * @author reparo
 * @date 2022/8/30
 */
public class TestCase {

    public static void main(String[] args) {
        test(new Integer[]{4, 1, 3, null, null, 2}, 5, new Integer[]{5, 4, null, 1, 3, null, null, 2});
        test(new Integer[]{5, 2, 4, null, 1}, 3, new Integer[]{5, 2, 4, null, 1, null, 3});
        test(new Integer[]{5, 2, 3, null, 1}, 4, new Integer[]{5, 2, 4, null, 1, 3});
    }

    public static void test(Integer[] nums, int val, Integer[] expectedResult) {
        final TreeNode actualValue = new Solution().insertIntoMaxTree(buildATree(nums), val);
        final Integer[] actualArray = parseTree(actualValue);
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (Arrays.equals(actualArray, expectedResult) ? String.format("result is %s, correct!", Arrays.toString(actualArray)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", Arrays.toString(expectedResult), Arrays.toString(actualArray))));
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
