class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, nums, nums.length, ans, temp);
        return ans;
    }

    public static void helper(
        int idx, int[] nums, int length, List<List<Integer>> ans, List<Integer> temp) {
        if (idx >= length) {
            List<Integer> ls = new ArrayList<>(temp);
            ans.add(ls);
            return;
        }
        temp.add(nums[idx]);
        helper(idx + 1, nums, length, ans, temp); // take it
        temp.removeLast();
        helper(idx + 1, nums, length, ans, temp); // not take it
    }
}
