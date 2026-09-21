class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        int l = 0;
        int r = 0;
        int[] ans = new int[n - k + 1];


        while (r < k) {
            maxHeap.add(nums[r]);
            r++;
        }
        ans[l] = maxHeap.peek();
        while (r < n) {
            maxHeap.remove(nums[l]);
            l++;
            maxHeap.add(nums[r]);
            r++;
            ans[l] = maxHeap.peek();
        }
        return ans;
    }
}
