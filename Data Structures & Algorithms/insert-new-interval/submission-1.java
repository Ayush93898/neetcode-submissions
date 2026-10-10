class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        boolean insert = false;
        int n = intervals.length;

        if (n == 0)
            return new int[][] {newInterval};

        for (int i = 0; i < n; i++) {
            if (!insert && intervals[i][0] >= newInterval[0]) {
                ls.add(newInterval);
                insert = true;
            }
            ls.add(intervals[i]);
        }

        if (!insert) {
            ls.add(newInterval);
        }

        return merge(ls.toArray(new int[ls.size()][]));
    }
     public int[][] merge(int[][] intervals) {
        // sort on the basic of start
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        int s1 = intervals[0][0];
        int e1 = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];

            // check if merging or not
            if(e1 >= s2){
                s1 = s1;
                e1 = Math.max(e1,e2);
                continue;
            }
            ans.add(new int[]{s1,e1});
            s1 = s2;
            e1 = e2;
        }

        ans.add(new int[]{s1,e1});

        return ans.toArray(new int[ans.size()][]);
    }
}
