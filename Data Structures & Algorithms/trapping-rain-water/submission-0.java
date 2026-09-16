class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefMax = new int[n];
        int[] suffMax = new int[n];

        prefMax[0] = height[0];
        suffMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            if (height[i] >= prefMax[i - 1])
                prefMax[i] = height[i];
            else
                prefMax[i] = prefMax[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            if (height[i] >= suffMax[i + 1])
                suffMax[i] = height[i];
            else
                suffMax[i] = suffMax[i + 1];
        }

        int trapingWater = 0;
        for (int i = 1; i < n - 1; i++) {
            trapingWater += Math.min(prefMax[i], suffMax[i]) - height[i];
        }
        return trapingWater;
    }
}
