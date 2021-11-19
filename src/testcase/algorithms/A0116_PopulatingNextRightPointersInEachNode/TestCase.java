package testcase.algorithms.A0116_PopulatingNextRightPointersInEachNode;

import problems.algorithms.A0116_PopulatingNextRightPointersInEachNode.Node;
import problems.algorithms.A0116_PopulatingNextRightPointersInEachNode.Solution;

import java.util.*;

/**
 * A0116_PopulatingNextRightPointersInEachNode
 *
 * @author reparo
 * @date 2021/11/20
 */
public class TestCase {

    public static void main(String[] args) {
        test(buildATree(new Integer[]{1, 2, 3, 4, 5, 6, 7}), Arrays.asList(1, null, 2, 3, null, 4, 5, 6, 7, null));
        test(buildATree(new Integer[]{}), List.of());
    }

    public static void test(Node root1, List<Integer> expectedResult) {
        final List<Integer> paramArray = parseTree(root1);
        final Node actualValue = new Solution().connect(root1);
        final List<Integer> actualArray = parseNext(actualValue);
        System.out.println(String.format("param is %s, ", paramArray) +
                (Objects.equals(actualArray, expectedResult) ? String.format("result is %s, correct!", actualArray) :
                        String.format("expectedResult is %s, actualValue is %s, failed", expectedResult, actualArray)));
    }

    public static Node buildATree(final Integer[] treeArray) {
        if (treeArray.length == 0) {
            return null;
        }

        int rows = 0, col = 0, isLeft = 1;
        final List<List<Node>> treeRows = new ArrayList<>();
        treeRows.add(new ArrayList<>());
        Node root = new Node(0);
        for (final Integer j : treeArray) {
            if (rows == 0) {
                root = new Node(treeArray[0]);
                treeRows.get(rows).add(root);
            } else {
                final Node thisParentNode = treeRows.get(rows - 1).get(col);
                final Node thisNode = j == null ? null : new Node(j);
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

    public static List<Integer> parseTree(final Node rootNode) {
        final Queue<Node> deque = new LinkedList<>();
        final ArrayList<Integer> ints = new ArrayList<>();
        deque.add(rootNode);

        while (!deque.isEmpty() && !deque.stream().allMatch(Objects::isNull)) {
            final Node node = deque.poll();
            ints.add(node == null ? null : node.val);
            if (node != null) {
                deque.add(node.left);
                deque.add(node.right);
            }
        }

        return ints;
    }

    public static List<Integer> parseNext(final Node node) {
        Node leftNode = node;
        Node curNode = node;
        final ArrayList<Integer> integers = new ArrayList<>();
        while (leftNode != null) {
            while (curNode != null) {
                integers.add(curNode.val);
                curNode = curNode.next;
            }

            integers.add(null);
            leftNode = leftNode.left;
            curNode = leftNode;
        }

        return integers;
    }
}
