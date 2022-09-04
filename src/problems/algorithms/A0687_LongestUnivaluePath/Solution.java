package problems.algorithms.A0687_LongestUnivaluePath;

/**
 * 给定一个二叉树的root，返回最长的路径的长度 ，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * <p>
 * 示例 1:
 * <a href="https://assets.leetcode.com/uploads/2020/10/13/ex1.jpg">...</a>
 * <p>
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * 示例 2:
 * <a href="https://assets.leetcode.com/uploads/2020/10/13/ex2.jpg">...</a>
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 * <p>
 * <p>
 * 提示:
 * <p>
 * 树的节点数的范围是[0, 104]
 * -1000 <= Node.val <= 1000
 * 树的深度将不超过 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-univalue-path">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/9/4
 */
public class Solution {

    /**
     * 对于一个节点，能构成的最长的路径的长度，取决于
     * <ul>
     *     <li>如果他和左右子节点是一样的值，则最长的路径是不以他本身为终点的，最长左路径+最长右路径 + 1</li>
     *     <li>如果他和左右子节点其中一个是一样的值，则最长的路径是以他本身为终点的，最长左路径或者最长右路径 + 1</li>
     *     <li>如果他和左右子节点是不一样的值，则包含他的节点最长为1</li>
     * </ul>
     * 我们用一个二元组来存这个信息，一个节点的二元组的左值表示他左路径Or右路径以他为终点的最长路径长度，右值表示以他为根节点的树内的最长长度
     * <p>
     * 时间复杂度 : O(nm).
     * 空间复杂度 : O(nm).
     * <p>
     * 解答消耗参考:
     * Runtime: 3 ms, 50.28%
     * Memory Usage: 39.0 MB, 47.84%
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int[] pairs = innerLongestUnivaluePath(root);
        return Math.max(pairs[0], pairs[1]);
    }

    private int[] innerLongestUnivaluePath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        final int[] leftMax = innerLongestUnivaluePath(root.left);
        final int[] rightMax = innerLongestUnivaluePath(root.right);

        final int leafMax = Math.max(leftMax[0], rightMax[0]);
        final int rootMax = Math.max(leftMax[1], rightMax[1]);
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            return new int[]{leafMax + 1, Math.max(leftMax[0] + rightMax[0] + 2, rootMax)};
        } else if (root.left != null && root.val == root.left.val) {
            return new int[]{leftMax[0] + 1, Math.max(leftMax[0] + 1, rootMax)};
        } else if (root.right != null && root.val == root.right.val) {
            return new int[]{rightMax[0] + 1, Math.max(rightMax[0] + 1, rootMax)};
        } else {
            return new int[]{0, rootMax};
        }
    }
}
