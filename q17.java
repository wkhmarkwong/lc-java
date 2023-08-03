/* question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/


backtracking

tc: O(n^4 * n) -> worst case is "9999" which has 4 choices in each level. When reaching the end, The whole state arraylist is copied.

sc:O(n)

n = length of digits

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