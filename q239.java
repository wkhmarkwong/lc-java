/* question: https://leetcode.com/problems/sliding-window-maximum/description/

approach: heap

tc: O(nlogk)
sc: O(n)

 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0])); // pq of {num, ind}

        for (int i = 0; i < k; i++) {
            pq.add(new int[] {nums[i], i});
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = pq.peek()[0];
        int ansInd = 1;

        for (int i = k; i < nums.length; i++) {
            pq.add(new int[] {nums[i], i});
            while (!pq.isEmpty() && pq.peek()[1] < i - k + 1) pq.poll();
            ans[ansInd] = pq.peek()[0];
            ansInd++;
        }

        return ans;

    }
}