class Solution {
    public int maxArea(int[] heights) {
        int maxCap = -1;
        int n = heights.length;
        int p1 = 0;
        int p2 = n-1;
        while(p1<p2){
            int area = Math.min(heights[p1],heights[p2]) * (p2-p1);
            if(area > maxCap) maxCap = area;
            if(heights[p1] <= heights[p2])p1++;
            else p2--;
        }
        return maxCap;
    }
}
