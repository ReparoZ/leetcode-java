package testcase.algorithms.A0617_MergeTwoBinaryTrees;

import problems.algorithms.A0617_MergeTwoBinaryTrees.Solution;
import problems.algorithms.A0617_MergeTwoBinaryTrees.TreeNode;

import java.util.*;

/**
 * A0617_MergeTwoBinaryTrees
 *
 * @author reparo
 * @date 2021/11/18
 */
public class TestCase {

    public static void main(String[] args) {
        test(buildATree(new Integer[]{1, 3, 2, 5}), buildATree(new Integer[]{2, 1, 3, null, 4, null, 7}), new Integer[]{3, 4, 5, 5, 4, null, 7});
    }

    public static void test(TreeNode root1, TreeNode root2, Integer[] expectedResult) {
        final TreeNode actualValue = new Solution().mergeTrees(root1, root2);
        final Integer[] actualArray = parseTree(actualValue);
        System.out.println(String.format("param1 is %s, param2 is %s, ", Arrays.toString(parseTree(root1)), Arrays.toString(parseTree(root2))) +
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
