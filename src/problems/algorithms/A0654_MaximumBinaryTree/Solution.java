package problems.algorithms.A0654_MaximumBinaryTree;

import java.util.Stack;

/**
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 * <p>
 *
 *
 * 示例 1：
 * <a href="https://assets.leetcode.com/uploads/2020/12/24/tree1.jpg">...</a>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 * 示例 2：
 * <a href="https://assets.leetcode.com/uploads/2020/12/24/tree2.jpg">...</a>
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 *
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-binary-tree">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/8/30
 */
public class Solution {

    /**
     * 解：用栈构建这个二叉树，每当遇到更大的数的时候弹栈弹到比这个数大，然后把原有right放到这个数对应节点的left，否则继续压栈
     * <p>
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     * <p>
     * 解答消耗参考:
     * Runtime: 5 ms, 82.95%
     * Memory Usage: 38.4 MB, 94.14%
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode rootNode = new TreeNode(1001);
        final Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(rootNode);

        for (final int num : nums) {
            final TreeNode newNode = new TreeNode(num);
            while (nodeStack.peek().val <= newNode.val) {
                nodeStack.pop();
            }

            newNode.left = nodeStack.peek().right;
            nodeStack.peek().right = newNode;
            nodeStack.push(newNode);
        }

        return rootNode.right;
    }
}
