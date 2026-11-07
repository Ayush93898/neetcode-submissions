class Solution {
    public int largestRectangleArea(int[] heights) {
        // for this qs we have to find the left smaller index and right smaller index
        int n = heights.length;

        int[] NSL = new int[n]; // next-smaller-index-LEFT
        int[] NSR = new int[n]; // next-smaller-index-RIGHT

        Deque<Integer> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st1.isEmpty() && heights[i] <= heights[st1.peek()]) {
                st1.pop();
            }

            if (!st1.isEmpty()) {
                NSR[i] = st1.peek();
            } else {
                NSR[i] = n;
            }

            st1.push(i);
        }

        for (int i = 0; i < n; i++) {
            while (!st2.isEmpty() && heights[i] <= heights[st2.peek()]) {
                st2.pop();
            }

            if (!st2.isEmpty()) {
                NSL[i] = st2.peek();
            } else {
                NSL[i] = -1;
            }

            st2.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int length = heights[i];
            int width = NSR[i] - NSL[i] - 1;
            int area = length * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}