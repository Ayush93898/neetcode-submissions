class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // boolean[] freq = new boolean[nums.length];
        helper1(0,nums,ans);
        return ans;
    }
    void helper1(int idx, int[] nums, List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums) temp.add(num);
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(i,idx,nums);
            helper1(idx+1,nums,ans);
            swap(i,idx,nums); // re-swap -- basic backtrack
        }
    }
    void swap(int p1, int p2, int[] arr){
        int temp = arr[p1];
        arr[p1] =  arr[p2];
        arr[p2] = temp;
    }
}
