package problems.algorithms.A0677_MapSumPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MapSum 类，支持两个方法，insert和sum：
 * <p>
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * <p>
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * '
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/14
 */
public class MapSum2 {

    static class TrieNode {
        int val = 0;
        final TrieNode[] next = new TrieNode[26];
    }

    private final TrieNode root = new TrieNode();

    private final Map<String, Integer> valueMap = new HashMap<>();

    public MapSum2() {

    }

    public void insert(String key, int val) {
        final char[] chars = key.toCharArray();
        int delta = val - valueMap.getOrDefault(key, 0);
        valueMap.put(key, val);
        TrieNode node = root;
        for (char c : chars) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.val += delta;
        }
    }

    /**
     * 前缀哈希映射
     *
     * 时间复杂度 : 插入O(N)，求和O(N)，其中 N 是插入或查询的字符串的长度.
     * 空间复杂度 : O(nm)，其中 N 是插入的 key-value 的数目，M 是字符串 key 最大的长度.
     *
     * 解答消耗参考:
     * Runtime: 11 ms, 99.71%
     * Memory Usage: 38.4 MB, 64.99%
     */
    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.val;
    }
}
