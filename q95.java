/* question: https://leetcode.com/problems/unique-binary-search-trees-ii/

 */

class Solution {
    List<TreeNode>[][] cache;

    public List<TreeNode> generateTrees(int n) {
        cache = new List[n+1][n+1];
        return dp(1, n);
    }

    public List<TreeNode> dp(int left, int right) {
        List<TreeNode> res = new ArrayList<>();

        if (left > right) {
            res.add(null);
            return res;
        }

        if (cache[left][right] != null) return cache[left][right];

        for (int centerVal = left; centerVal <= right; centerVal++) {
            List<TreeNode> leftPoss = dp(left, centerVal-1);
            List<TreeNode> rightPoss = dp(centerVal+1, right);
            for (TreeNode leftNode: leftPoss) {
                for (TreeNode rightNode: rightPoss) {
                    res.add(new TreeNode(centerVal, leftNode, rightNode));
                }
            }
        }

        cache[left][right] = res;
        return cache[left][right];
    }
}