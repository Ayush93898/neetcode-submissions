class Solution {
    public boolean canJump(int[] nums) {
        int maxIdxYouCanReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIdxYouCanReach)
                return false;
            maxIdxYouCanReach = Math.max(maxIdxYouCanReach, i + nums[i]);
        }
        return true;
    }
}