class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort on the basic of end point
        Arrays.sort(intervals,Comparator.comparingInt(a->a[1]));
        //Yahan tu intervals ko earliest ending order mein arrange kar raha hai.
        int count = 1; // mean kitne count of interval rakh sakte h
        int n = intervals.length;
        int prevInterval = 0;

        // greed factor -- “Agar mujhe multiple intervals me se choose karna
        //  hai, toh main hamesha woh interval
        //   choose karunga jo sabse jaldi khatam hota hai.”
        for(int i=1; i<n; i++){
            // agr currnt inteval ka start num greater than ya equal hua
            // prev wale end number se.. so u can have it
            if(intervals[i][0] >= intervals[prevInterval][1]){
                prevInterval = i;
                count++;
            }
        }

        return n - count;
    }
}