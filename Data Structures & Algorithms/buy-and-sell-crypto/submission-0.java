class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int[] prefMin = new int[n];
        prefMin[0] = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] <= prefMin[i - 1]) {
                prefMin[i] = prices[i];
            } else {
                prefMin[i] = prefMin[i - 1];
            }
        }

        for(int i=0; i<n; i++){
            if(prices[i] - prefMin[i] > 0){
                ans = Math.max(ans,prices[i] - prefMin[i]);
            }
        }
        return ans;
    }
}
