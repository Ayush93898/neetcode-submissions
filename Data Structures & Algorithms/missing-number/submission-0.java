class Solution {
    public int missingNumber(int[] nums) {
        int ans1 = 0;
        int ans2 = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            ans1 = ans1 ^ nums[i];
        }
        for(int i=0; i<=n; i++)ans2 = ans2^i;
        return ans1 ^ ans2;
    }
}
