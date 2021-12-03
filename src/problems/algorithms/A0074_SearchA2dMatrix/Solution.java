package problems.algorithms.A0074_SearchA2dMatrix;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 *
 * 示例 1：
 * https://assets.leetcode.com/uploads/2020/10/05/mat.jpg
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/mat2.jpg
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author reparo
 * @date 2021/12/4
 */
public class Solution {

    /**
     * 二分法，先对首列进行二分找到列，再通过列找对应的数字
     *
     * 时间复杂度 : O(lgn).
     * 空间复杂度 : O(1).
     *
     * 解答消耗参考:
     * Runtime: 0 ms, 100.00%
     * Memory Usage: 38 MB, 17.22%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1, curRow = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[mid][0]) {
                return true;
            } else if (target > matrix[mid][0] && target < (mid == matrix.length - 1 ? Integer.MAX_VALUE : matrix[mid + 1][0])) {
                curRow = mid;
                break;
            } else if (target > matrix[mid][0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (curRow == -1) {
            return false;
        }

        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == matrix[curRow][mid]) {
                return true;
            } else if (target > matrix[curRow][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
