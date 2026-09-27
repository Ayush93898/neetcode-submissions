class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        helper1(nums, ans, new ArrayList<>(), freq);
        return ans;
    }
    void helper1(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) { // if not in map
                freq[i] = true; // make it present
                ds.add(nums[i]); // take it
                helper1(nums, ans, ds, freq);
                ds.remove(ds.size() - 1); // remove it
                freq[i] = false; // remove from the map, for going upward
            }
        }
    }
}
