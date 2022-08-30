package problems.algorithms.A0998_MaximumBinaryTreeII;

import java.util.Stack;

/**
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像 之前的问题 那样，给定的树是利用 Construct(a)例程从列表a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回null 。
 * 否则，令a[i] 作为 a 的最大元素。创建一个值为a[i]的根节点 root 。
 * root的左子树将被构建为Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root的右子树将被构建为Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回Construct(b) 。
 * <p>
 *
 * 示例 1：
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/maximum-binary-tree-1-1.png">...</a>
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/maximum-binary-tree-1-2.png">...</a>
 * <p>
 *
 * 输入：root = [4,1,3,null,null,2], val = 5
 * 输出：[5,4,null,1,3,null,null,2]
 * 解释：a = [1,4,2,3], b = [1,4,2,3,5]
 * 示例 2：
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/maximum-binary-tree-2-1.png">...</a>
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/maximum-binary-tree-2-2.png">...</a>
 * <p>
 * 输入：root = [5,2,4,null,1], val = 3
 * 输出：[5,2,4,null,1,null,3]
 * 解释：a = [2,1,5,4], b = [2,1,5,4,3]
 * 示例 3：
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/maximum-binary-tree-3-1.png">...</a>
 * <a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/02/23/maximum-binary-tree-3-2.png">...</a>
 * 输入：root = [5,2,3,null,1], val = 4
 * 输出：[5,2,4,null,1,3]
 * 解释：a = [2,1,5,3], b = [2,1,5,3,4]
 * <p>
 *
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 100] 内
 * 1 <= Node.val <= 100
 * 树中的所有值 互不相同
 * 1 <= val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-binary-tree-ii">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/8/30
 */
public class Solution {

    /**
     * 解：和A0654一个解法，因为插入的数相当于在数组的最右端，也就是在A0654的数组里多加了一个数而已，只要我们能构建A0654的栈就可以了，也就是这棵树最右边一条边对应的栈
     * <p>
     * 时间复杂度 : O(n)，n表示树的深度.
     * 空间复杂度 : O(n).
     * <p>
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 40.1 MB, 5.04%
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        final TreeNode virtualRoot = new TreeNode(101), newNode = new TreeNode(val);
        TreeNode curr;
        virtualRoot.right = root;
        curr = virtualRoot;
        final Stack<TreeNode> nodeStack = new Stack<>();
        while (curr != null) {
            nodeStack.push(curr);
            curr = curr.right;
        }

        while (nodeStack.peek().val <= newNode.val) {
            nodeStack.pop();
        }

        newNode.left = nodeStack.peek().right;
        nodeStack.peek().right = newNode;

        return virtualRoot.right;
    }
}
