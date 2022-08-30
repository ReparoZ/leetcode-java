package testcase.algorithms.A0654_MaximumBinaryTree;

import problems.algorithms.A0654_MaximumBinaryTree.Solution;
import problems.algorithms.A0654_MaximumBinaryTree.TreeNode;

import java.util.*;

/**
 * @author reparo
 * @date 2022/8/30
 */
public class TestCase {

    public static void main(String[] args) {
        test(new int[]{3, 2, 1, 6, 0, 5}, new Integer[]{6, 3, 5, null, 2, 0, null, null, 1});
        test(new int[]{3, 2, 1}, new Integer[]{3, null, 2, null, 1});
        test(new int[]{48, 259, 222, 129, 17, 245, 174, 68, 8, 261, 233, 112, 263, 41, 108, 209, 22, 35, 167, 133, 23, 201, 91, 190, 252, 182, 86, 15, 296, 103, 195, 207, 146, 275, 21, 204, 271, 248, 280, 66, 183, 28, 202, 78, 240, 92, 223, 264, 64, 163, 262, 25, 184, 242, 281, 288, 104, 158, 165, 67, 40, 272, 198, 273, 127, 290, 155, 197, 106, 226, 109, 81, 113, 119, 37, 168, 75, 214, 295, 237, 63, 192, 215, 251, 142, 218, 161, 80, 105, 20, 62, 100, 266, 39, 179, 83, 247, 269, 85, 234, 82, 118, 185, 277, 140, 122, 162, 128, 93, 139, 4, 216, 152, 285, 42, 102, 194, 175, 61, 210, 284, 14, 145, 299, 53, 213, 51, 0, 34, 79, 211, 1, 294, 94, 282, 125, 5, 249, 99, 173, 116, 220, 270, 45, 224, 144, 98, 177, 260, 46, 268, 230, 49, 107, 166, 77, 297, 178, 44, 231, 157, 159, 235, 131, 283, 120, 241, 6, 172, 123, 256, 19, 110, 150, 206, 33, 227, 170, 95, 31, 225, 130, 134, 257, 38, 30, 87, 254, 193, 3, 12, 236, 52, 186, 55, 180, 65, 72, 229, 154, 60, 115, 121, 219, 228, 76, 13, 238, 97, 217, 243, 27, 287, 88, 10, 169, 137, 244, 84, 73, 32, 286, 205, 156, 24, 151, 292, 160, 239, 50, 200, 70, 136, 138, 124, 189, 203, 191, 148, 153, 143, 276, 18, 221, 258, 278, 69, 57, 246, 2, 267, 176, 135, 16, 26, 187, 250, 181, 9, 11, 291, 255, 232, 265, 274, 149, 196, 212, 58, 89, 47, 117, 188, 132, 293, 54, 298, 171, 141, 208, 56, 147, 7, 101, 164, 114, 43, 199, 59, 111, 126, 74, 29, 279, 253, 71, 36, 289, 90, 96},
                new Integer[]{299, 296, 298, 263, 295, 297, 289, 261, 252, 290, 285, 294, 293, 279, 96, 259, 233, 209, 182, 288, 226, 277, 284, 213, 282, 292, 54, 208, 253, 90, null, 48, 245, null, 112, 108, 201, null, 86, 281, 273, 197, 214, 269, 216, 210, 145, 53, 211, 94, 270, 287, 291, null, null, 171, 199, null, 71, null, null, null, null, 222, 174, null, null, 41, null, 167, 190, null, 15, 280, null, 272, 127, 155, 106, 168, null, 266, 234, 162, 152, 194, null, 14, null, null, null, 79, 1, null, null, 249, 268, 283, 286, 278, 274, null, 141, 164, 126, null, 36, null, 129, null, 68, null, null, 35, 133, 91, null, null, null, 275, 264, 165, 198, null, null, null, null, null, null, 119, 75, 251, 247, 85, 185, 140, 139, null, null, 102, 175, null, null, 51, null, null, null, 125, 220, 260, 230, 235, 257, 244, 205, 276, 267, 265, 212, null, null, 147, 114, 111, 74, null, null, null, 17, null, 8, 22, null, null, 23, null, null, 207, 271, 240, 262, 158, 67, null, null, 113, 37, null, null, 237, 218, 179, null, null, null, 118, null, null, 122, 128, 4, 42, null, null, 61, null, 34, null, 5, 173, null, 224, 46, null, 166, 231, 131, 256, 254, 169, 84, null, 156, 239, 258, 246, 250, 255, null, 196, 188, 56, 101, null, 43, 59, null, null, 29, null, null, null, null, null, null, null, null, 195, 146, 204, 248, 202, 223, 163, 242, 104, null, null, 40, 109, null, null, null, null, 215, 142, 161, 39, 83, 82, null, null, null, null, 93, null, null, null, null, null, null, 0, null, null, null, 99, 116, 45, 177, null, null, 107, 77, 178, 159, null, null, 241, 227, 87, 243, 88, 137, null, 73, null, 151, 160, 203, 221, null, 69, 2, 187, 181, null, 232, 149, null, 117, 132, null, null, 7, null, null, null, null, null, null, null, 103, null, null, null, 21, null, null, null, 183, 78, 92, null, 64, null, 184, null, null, null, null, null, null, 81, 192, null, null, null, null, 105, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 144, null, 49, null, null, null, null, 44, 157, null, 120, 172, 206, 225, 38, null, 238, 27, null, 10, null, null, null, 32, 24, null, null, null, 200, 191, 18, null, null, 57, null, null, 176, null, null, 11, null, null, null, null, 89, null, null, null, null, null, null, null, null, null, 66, 28, null, null, null, null, null, null, 25, null, null, null, 63, null, 80, 100, null, 98, null, null, null, null, null, null, null, null, 6, 123, 150, 33, 170, 134, null, 30, 236, 217, null, null, null, null, null, null, null, null, 50, 189, null, 153, null, null, null, null, null, 135, 9, null, 58, 47, null, null, null, null, null, null, null, null, null, null, 62, null, null, null, null, null, null, null, 110, null, null, null, null, 95, 130, null, null, null, 193, 229, 97, null, null, null, 138, null, 148, 143, null, 26, null, null, null, null, null, null, 20, null, 19, null, null, 31, null, null, null, 12, 186, 228, null, null, 136, 124, null, null, null, null, 16, null, null, null, null, null, null, null, 3, null, 52, 180, 219, 76, 70, null, null, null, null, null, null, null, null, null, 55, 72, 154, null, null, 13, null, null, null, null, 65, null, null, 121, null, null, null, null, 115, null, 60});
    }

    public static void test(int[] nums, Integer[] expectedResult) {
        final TreeNode actualValue = new Solution().constructMaximumBinaryTree(nums);
        final Integer[] actualArray = parseTree(actualValue);
        System.out.println(String.format("param is %s, ", Arrays.toString(nums)) +
                (Arrays.equals(actualArray, expectedResult) ? String.format("result is %s, correct!", Arrays.toString(actualArray)) :
                        String.format("expectedResult is %s, actualValue is %s, failed", Arrays.toString(expectedResult), Arrays.toString(actualArray))));
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
