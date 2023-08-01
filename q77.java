/* question: https://leetcode.com/problems/combinations/description/


Intuition
For each element, you can choose either "put into state list" or "skip". Backtracking is good approach.
Approach

Backtracking
Complexity

Time complexity:
O(2^n) -> There are 2 choices in each level.

Space complexity:
O(n) -> recursion depth, state list

 */

class Solution {
    int n, k;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> state = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        bt(1);
        return ans;
    }

    public void bt(int i) {
        // reach size k
        if (state.size() == k) {
            List<Integer> copy = new ArrayList<>(state);
            ans.add(copy);
            return;
        }
        // exceed range
        if (i > n) {
            return;
        }

        // choose i
        state.add(i);
        bt(i + 1);
        state.remove(state.size() - 1);

        // skip i
        bt(i+1);
    }
}