class TimeMap {
    class TimeValue{
        int timeStamp;
        String value;

        TimeValue(int timeStamp, String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    HashMap<String, ArrayList<TimeValue>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)){
            mp.put(key, new ArrayList<>());
        }
        TimeValue obj = new TimeValue(timestamp,value);
        mp.get(key).add(obj);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";
        ArrayList<TimeValue> ls = mp.get(key);
        int low = 0;
        int high  = ls.size()-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(ls.get(mid).timeStamp <= timestamp){
                ans = mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        return ans == -1? "" : ls.get(ans).value;
    }
}
