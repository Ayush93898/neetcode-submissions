class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int num: nums){
            st.add(num);
        }
        return !(nums.length == st.size());
    }
}