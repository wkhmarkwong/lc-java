/* question: https://leetcode.com/problems/maximal-network-rank/description/

this question is about English comprehension

tc: O(E + V^2) -> build map and then double loops
sc: O(E) -> map is built from edge list

E = number of edges
V = number of vertice

 */

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer>[] n2nxt = new HashSet[n];
        for (int i = 0; i < n; i++) {
            n2nxt[i] = new HashSet<>();
        }

        for (int[] bridge : roads) {
            int x = bridge[0], y = bridge[1];
            n2nxt[x].add(y);
            n2nxt[y].add(x);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = n2nxt[i].size() + n2nxt[j].size();
                if (n2nxt[i].contains(j)) tmp--;
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}