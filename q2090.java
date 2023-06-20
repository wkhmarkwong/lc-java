// question: https://leetcode.com/problems/k-radius-subarray-averages/description/

/*
Approach
sliding window

Complexity

Time complexity:
O(n) -> all elements are read constant times

Space complexity:
O(1) -> only variables are used. ans array isnt counted in sc
*/

class Solution {

    long curTotal = 0;
    int center;
    int winSize;
    public int[] getAverages(int[] nums, int k) {

        winSize = k * 2 + 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        if (nums.length < winSize) return ans;

        for (int i = 0; i < winSize; i++) curTotal += nums[i];

        center = winSize / 2;
        ans[center] = helper();

        for (int i = winSize; i < nums.length; i++) {
            int offseti = i - winSize;
            curTotal = curTotal - nums[offseti] + nums[i];
            center++;
            ans[center] = helper();
        }
        return ans;
    }

    public int helper() {
        return (int) (curTotal / winSize);
    }
}