package problems.algorithms.A0391_PerfectRectangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 *
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 *
 * 
 * 示例 1：
 * https://assets.leetcode.com/uploads/2021/03/27/perectrec1-plane.jpg
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 * 示例 2：
 * https://assets.leetcode.com/uploads/2021/03/27/perfectrec2-plane.jpg
 *
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 * 示例 3：
 * https://assets.leetcode.com/uploads/2021/03/27/perfectrec3-plane.jpg
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
 * 输出：false
 * 解释：图形顶端留有空缺，无法覆盖成一个矩形。
 * 示例 4：
 * https://assets.leetcode.com/uploads/2021/03/27/perfecrrec4-plane.jpg
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * 
 *
 * 提示：
 *
 * 1 <= rectangles.length <= 2 * 10^4
 * rectangles[i].length == 4
 * -10^5 <= xi, yi, ai, bi <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/11/16
 */
public class Solution {

    /**
     * 判断是否能组成一个矩形的条件是
     * 1. 四个顶点所组成的大矩形面积等于各个小矩形面积之和（确保矩形区域中不能有空缺）
     * 2. 大矩形的四角的顶点，都只出现了1次
     * 3. 其余顶点的出现次数只能是两次或四次
     *
     * 时间复杂度 : O(n).
     * 空间复杂度 : O(n).
     *
     * 解答消耗参考:
     * Runtime: 126 ms, 5.49%
     * Memory Usage: 46.7 MB, 83.53%
     */
    public boolean isRectangleCover(int[][] rectangles) {
        int areaSum = 0, minX = rectangles[0][0], minY = rectangles[0][1], maxA = rectangles[0][2], maxB = rectangles[0][3];
        final Map<List<Integer>, Integer> pointCnt = new HashMap<>();
        for (final int[] rectangle : rectangles) {
            areaSum += calArea(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
            minX = Math.min(minX, rectangle[0]);
            minY = Math.min(minY, rectangle[1]);
            maxA = Math.max(maxA, rectangle[2]);
            maxB = Math.max(maxB, rectangle[3]);

            pointCnt.compute(List.of(rectangle[0], rectangle[1]), (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            pointCnt.compute(List.of(rectangle[2], rectangle[1]), (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            pointCnt.compute(List.of(rectangle[0], rectangle[3]), (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            pointCnt.compute(List.of(rectangle[2], rectangle[3]), (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }

        if ((maxA - minX) * (maxB - minY) != areaSum) {
            return false;
        } else {
            for (Map.Entry<List<Integer>, Integer> pointMapCnt : pointCnt.entrySet()) {
                if (pointMapCnt.getKey().equals(List.of(minX, minY)) ||
                        pointMapCnt.getKey().equals(List.of(minX, maxB)) ||
                        pointMapCnt.getKey().equals(List.of(maxA, minY)) ||
                        pointMapCnt.getKey().equals(List.of(maxA, maxB))) {
                    if (pointMapCnt.getValue() != 1) {
                        return false;
                    }
                } else if (pointMapCnt.getValue() != 2 && pointMapCnt.getValue() != 4) {
                    return false;
                }
            }
        }

        return true;
    }

    private int calArea(int x, int y, int a, int b) {
        return (a - x) * (b - y);
    }
}
