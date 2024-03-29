package problems.algorithms.A0733_FloodFill;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标(sr, sc)表示图像渲染开始的像素值（行 ，列）和一个新的颜色值newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * 示例 1:
 *
 * 输入: 
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析: 
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * 注意:
 *
 * image 和image[0]的长度在范围[1, 50] 内。
 * 给出的初始点将满足0 <= sr < image.length 和0 <= sc < image[0].length。
 * image[i][j] 和newColor表示的颜色值在范围[0, 65535]内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author reparo
 * @date 2021/11/17
 */
public class Solution {

    /**
     * 深度优先搜索/广度优先搜索
     *
     * 时间复杂度 : O(nm).
     * 空间复杂度 : O(nm).
     *
     * 解答消耗参考:
     * Runtime: 1 ms, 62.90%
     * Memory Usage: 38.9 MB, 93.61%
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0){
            return image;
        }

        paintNewColor(image, new boolean[image.length][image[0].length], sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void paintNewColor(int[][] image, boolean[][] visited, int x, int y, int rawColor, int newColor) {
        if (x < 0 || x >= image.length) {
            return;
        }

        if (y < 0 || y >= image[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        } else {
            visited[x][y] = true;
        }

        if (image[x][y] == rawColor) {
            image[x][y] = newColor;
        } else {
            return;
        }

        paintNewColor(image, visited, x + 1, y, rawColor, newColor);
        paintNewColor(image, visited, x - 1, y, rawColor, newColor);
        paintNewColor(image, visited, x, y + 1, rawColor, newColor);
        paintNewColor(image, visited, x, y - 1, rawColor, newColor);
    }
}
