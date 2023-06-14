// question: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    TreeNode prev;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return this.ans;
    }

    public void dfs(TreeNode n) {
        if (n == null) return;

        dfs(n.left);
        if (this.prev != null) {
            this.ans = Math.min(this.ans, n.val - this.prev.val);
        }
        this.prev = n;
        dfs(n.right);
    }
}

/*
Intuition

If you read a BST using inorder traversal, it becomes a sorted list.
Approach

dfs
Complexity

    Time complexity:
    O(n)

    Space complexity:
    O(d), d = tree depth, without using extra list
 */