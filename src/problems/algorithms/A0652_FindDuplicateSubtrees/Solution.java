package problems.algorithms.A0652_FindDuplicateSubtrees;

import java.util.*;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 *
 *
 * 示例 1：
 * <a href="https://assets.leetcode.com/uploads/2020/08/16/e1.jpg">...</a>
 * <p>
 *
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 * https://assets.leetcode.com/uploads/2020/08/16/e2.jpg
 * <p>
 *
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 * https://assets.leetcode.com/uploads/2020/08/16/e33.jpg
 * <p>
 *
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 * <p>
 *
 * 提示：
 * <p>
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-duplicate-subtrees">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2022/9/5
 */
public class Solution {

    private final Map<String, Map.Entry<TreeNode, Integer>> pairCache = new HashMap<>();
    private final Set<TreeNode> repeat = new HashSet<>();
    private int seq = 0;

    /**
     * 我们给每一种样子的子树编号，那么对于每一个根节点，树相等的条件是：
     * [左子树序号，根节点类型，右子树序号]这个三元组相等，我们采用深度优先算法，将每一个子树第一次看到的时候缓存起来给与编码，
     * 每次发现有树能命中缓存值，则将其加入到结果集中，就可得出从根节点开始的相等树
     * <p>
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     * <p>
     * 解答消耗参考:
     * Runtime: 5 ms, 99.68%
     * Memory Usage: 42.0 MB, 99.82%
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        calNodeSeq(root);
        return new ArrayList<>(repeat);
    }

    private int calNodeSeq(final TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }

        final int[] tri = {rootNode.val, calNodeSeq(rootNode.left), calNodeSeq(rootNode.right)};
        final String hash = Arrays.toString(tri);
        if (pairCache.containsKey(hash)) {
            final Map.Entry<TreeNode, Integer> entry = pairCache.get(hash);
            repeat.add(entry.getKey());
            return entry.getValue();
        } else {
            pairCache.put(hash, Map.entry(rootNode, ++seq));
            return seq;
        }
    }
}
