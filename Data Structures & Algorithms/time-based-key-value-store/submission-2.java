class TimeMap {
    HashMap<String, Map<Integer, String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
 

    public void set(String key, String value, int timestamp) {
        if (!mp.containsKey(key)) {
            mp.put(key, new HashMap<>());
        }
        mp.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!mp.containsKey(key))
            return "";
        Map<Integer, String> m = mp.get(key);
        if (m.isEmpty())
            return "";

        int bestTimestamp = -1;
        for (int k : m.keySet()) {
            if(k <= timestamp && k>bestTimestamp) bestTimestamp = k;
        }
        return bestTimestamp == -1 ? "" : m.get(bestTimestamp);
    }
}
