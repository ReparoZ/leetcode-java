package problems.algorithms.A0677_MapSumPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MapSum 类，支持两个方法，insert'和'sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * '
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * '
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/11/14
 */
public class MapSum {

    private final Map<String, Integer> innerMap = new HashMap<>();

    public MapSum() {

    }

    public void insert(String key, int val) {
        innerMap.put(key, val);
    }

    /**
     * 暴力扫描
     *
     * 时间复杂度 : 插入O(1)，求和O(nm)，其中 N 是插入的 key 的数目，M 是给定前缀 prefix 的长度.
     * 空间复杂度 : O(nm)，其中 N 是插入的 key 的数目，M 是字符串 key 的长度.
     *
     * 解答消耗参考:
     * Runtime: 12 ms, 66.71%
     * Memory Usage: 38.3 MB, 77.65%
     */
    public int sum(String prefix) {
        int sum = 0;
        for (final Map.Entry<String, Integer> entry : innerMap.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }

        return sum;
    }
}
