class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> st = new HashSet<>();

        // put all the numberes in the set
        for(int num : nums) st.add(num);

        // iterate each num in nums, and check for num-1
        // if num-1 did't exist -> staring of sequence
        // update a counter and maxCount also

        int maxCount = 1;
        for(int num: nums){
            int cnt = 1;
            if(!st.contains(num-1)){
                while(st.contains(num+1)){
                    cnt++;
                    num++;
                }
            }
            maxCount = Math.max(maxCount, cnt);
        }
        return maxCount;
    }
}
