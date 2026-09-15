class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        int[] prefProd = new int[n];
        int[] suffProd = new int[n];

        // cal prefProd
        prefProd[0] = nums[0];
        for(int i=1; i<n; i++) prefProd[i] = prefProd[i-1]*nums[i];

        // cal suffProd
        suffProd[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) suffProd[i] = suffProd[i+1]*nums[i];

        // cal ans
        ans[0] = suffProd[1];
        ans[n-1] = prefProd[n-2];
        for(int i=1; i<n-1; i++) ans[i] = prefProd[i-1]*suffProd[i+1];

        return ans;
    }
}  
