/* question: https://leetcode.com/problems/permutations/description/


backtracking

tc: O(n! * n) -> Consider array [1,2,3,4,5,6]. There are 6 choices for the first one. There are 5 choices for the second one. And so one. The relationship is factorial. When terminal has been touched, a new arraylist is created which will cost O(n) tc.

sc: O(n) -> backtracking's depth, state arraylist

n = nums.length

 */

import java.util.*;

class Solution {

    int[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> state = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        bt();
        return ans;
    }

    private void bt() {
        if (nums.length == state.size()) {
            ans.add(new ArrayList<>(state));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int tmp = nums[i];
                nums[i] = Integer.MAX_VALUE;
                state.add(tmp);

                bt();

                nums[i] = tmp;
                state.remove(state.size() - 1);
            }
        }
    }

}