class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if(i>0){
                while(i<n && nums[i]==nums[i-1]) i++;
            }
            int p = i;
            int q = p + 1;
            int r = n - 1;
            while (q < r) {
                
                if (nums[p] + nums[q] + nums[r] == 0){
                    ans.add(Arrays.asList(nums[p], nums[q], nums[r]));
                    while(q<n-1 && nums[q]==nums[q+1] )q++;
                    while(r>0 && nums[r]==nums[r-1] )r--;
                    q++;
                    r--;

                }
                    
                else if(nums[p] + nums[q] + nums[r] > 0) r--;
                else q++;
            }
        }
        return ans;
    }
}
