class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;

            // find the sorted half
            if(nums[low] <= nums[mid]){ // i.e left sorted
                // search whether target lies in this range
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }else low = mid + 1;
            }else{
                // right half sorted hai
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else high = mid - 1;
            }
        }

        return -1;
    }
}
