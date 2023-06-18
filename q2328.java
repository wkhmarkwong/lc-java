// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/

class Solution {
    int m, n;
    int[][] cache;
    final int mod = (int) Math.pow(10, 9) + 7;
    int[][] di = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] grid;
    public int countPaths(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.cache = new int[m+1][n+1];
        this.grid = grid;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(i, j)) % mod;
            }
        }

        return ans;
    }

    public int dfs(int i, int j) {
        if (cache[i][j] != 0) return cache[i][j];

        int res = 1;

        for (int[] nxt : di) {
            int ni = i + nxt[0], nj = j + nxt[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] > grid[i][j]) {
                res = (res + dfs(ni, nj)) % mod;
            }
        }
        return cache[i][j] = res;
    }
}