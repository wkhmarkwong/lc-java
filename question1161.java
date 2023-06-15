// question: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/


/*
DFS
Complexity

Time complexity:
O(n) -> read all nodes once

Space complexity:
O(d) -> d = dfs depth. level2sum dict consumes O(d) space too
*/

class Solution {

    Map<Integer, Integer> lvToTotal;
    public int maxLevelSum(TreeNode root) {
        this.lvToTotal = new HashMap<>();

        dfs(root, 1);
        int ans = 0, maxi = Integer.MIN_VALUE;

        for (int lv : this.lvToTotal.keySet()){
            if (maxi < this.lvToTotal.get(lv)) {
                ans = lv;
                maxi = this.lvToTotal.get(lv);
            }
        }

        return ans;
    }

    public void dfs(TreeNode n, int lv) {
        if (n == null) return;
        this.lvToTotal.put(lv, this.lvToTotal.getOrDefault(lv, 0) + n.val);
        dfs(n.left, lv + 1);
        dfs(n.right, lv + 1);
    }
}


/*
BFS
Complexity

Time complexity:
O(n) -> read all nodes once

Space complexity:
O(w) -> w = tree width, because queue will store at most w elements
*/


class Solution {
    public int maxLevelSum(TreeNode root) {
        int ans = 0, maxi = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int lv = 1;

        while (queue.size() > 0) {
            int total = 0;
            int ss =queue.size();
            for (int i = 0; i < ss; i++) {
                TreeNode curNode = queue.poll();
                total += curNode.val;
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }
            if (total > maxi) {
                ans = lv;
                maxi = total;
            }
            System.out.println(total);
            lv++;

        }
        return ans;

    }
}
