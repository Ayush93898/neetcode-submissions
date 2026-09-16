class Solution {
    public int maxProfit(int[] prices) {
        // by prefix Min
        // int ans = 0;
        // int n = prices.length;
        // int[] prefMin = new int[n];
        // prefMin[0] = prices[0];
        // for (int i = 1; i < n; i++) {
        //     if (prices[i] <= prefMin[i - 1]) {
        //         prefMin[i] = prices[i];
        //     } else {
        //         prefMin[i] = prefMin[i - 1];
        //     }
        // }

        // for(int i=0; i<n; i++){
        //     if(prices[i] - prefMin[i] > 0){
        //         ans = Math.max(ans,prices[i] - prefMin[i]);
        //     }
        // }
        // return ans;

        // by sliding window
        int low = 0;
        int high = 1;
        int maxP = 0;

        int n = prices.length;
        while(high < n){
            if(prices[low] < prices[high]){
                int prof = prices[high] - prices[low];
                maxP = Math.max(prof, maxP);
            } else low = high;
            high++;
        }
        return maxP;
    }
}
