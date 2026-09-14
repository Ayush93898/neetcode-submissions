class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>(); // num | freq
        for(int num: nums) mp.put(num, mp.getOrDefault(num,0)+1);

        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            list.add(new int[]{entry.getValue(),entry.getKey()});
        }

        list.sort((a,b)->b[0]-a[0]);
        int[] res = new int[k];
        for(int i=0; i<k; i++) res[i] = list.get(i)[1];

        return res;
    }
}
