// question: https://leetcode.com/problems/equal-row-and-column-pairs/

import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<String, Integer> tup2f = new HashMap<>();

        for (int j = 0; j < n; j++) {
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = grid[i][j];
            }
            String key = Arrays.toString(tmp);
            tup2f.put(key, tup2f.getOrDefault(key, 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            String query = Arrays.toString(grid[i]);
            ans += tup2f.getOrDefault(query,0);
        }

        return ans;
    }

}

/*
Since number is hashable, you can do it better by hashing the matrix.
Complexity

Time complexity:
O(n^2) -> double loops

Space complexity:
O(n^2) -> dict to store all tuples
 */