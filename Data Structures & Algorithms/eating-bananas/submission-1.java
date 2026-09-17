class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = -1;

        // finding range of k [1.....max(piles)]
        int low = 1;
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            if(pile > max) max = pile;
        }
        System.out.println(max);
        // now we have low and max --  apply bs
        while(low <= max){
            int mid = low + (max - low)/2;
            int howMantHrItTakes = helper(piles, mid);
            if(howMantHrItTakes <= h) {
                ans = mid;
                max = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
    int helper(int[] piles, int k){
        int totalTime = 0;
        for(int i=0; i<piles.length; i++){
           totalTime += (int) Math.ceil((double) piles[i] / k); 
        }
        return totalTime;
    }
}
