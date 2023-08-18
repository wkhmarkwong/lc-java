/* question: https://leetcode.com/problems/01-matrix/description/

approach: bfs

tc:O(mn) -> all cells are iterated constant time
sc:O(mn) -> queue may has mn space usage in max

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int[] array : ans) Arrays.fill(array, -1);

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.add(new int[] {i, j});
            }
        }

        int step = 0;
        int[][] dir = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!queue.isEmpty()) {
            int b = queue.size();
            for (int a = 0; a < b; a++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];

                if (!(i >= 0 && i < m && j >= 0 && j < n)) continue; // exceed grid
                if (ans[i][j] != -1) continue; // visited
                ans[i][j] = step;

                for (int[] tmp : dir) {
                    int ii = tmp[0], jj = tmp[1];
                    queue.add(new int[] {i+ii, j+jj});
                }
            }
            step++;
        }

        return ans;

    }
}