class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper2(0, nums, ans, new ArrayList<>());
        return ans;
    }
    void helper2(int idx, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            helper2(i + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
