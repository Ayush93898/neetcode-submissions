class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // brute force - o(n2 k)
        // List<List<String>> ans = new ArrayList<>();
        // boolean[] visited = new boolean[strs.length];

        // for(int i=0;i<strs.length; i++){
        //     if(visited[i]) continue;

        //     List<String> temp = new ArrayList<>();
        //     temp.add(strs[i]);
        //     visited[i] = true;

        //     for(int j=i+1; j<strs.length; j++){
        //         if(!visited[j] && isAnagram(strs[i],strs[j])){
        //             temp.add(strs[j]);
        //             visited[j] = true;
        //         }
        //     }
        //     ans.add(temp);
        // }
        // return ans;

        // Better (n * logk)
        // HashMap<String, List<String>> mp = new HashMap<>();
        // for(int i=0; i<strs.length; i++){
        //     char[] chars = strs[i].toCharArray();
        //     Arrays.sort(chars);
        //     String sorted = new String(chars);

        //     if(!mp.containsKey(sorted)){
        //         mp.put(sorted,new ArrayList<>());
        //     }
        //     mp.get(sorted).add(strs[i]);
        // }
        // return new ArrayList<>(mp.values());

        // optimal o(nk)
        HashMap<String, List<String>> mp = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            int[] arr = new int[26];
            String str = strs[i];
            for(int j=0;j<str.length(); j++) arr[str.charAt(j) - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int num: arr) sb.append(num).append('#');
            String s = sb.toString();
            if(!mp.containsKey(s)){
                mp.put(s,new ArrayList<>());
            }
            mp.get(s).add(strs[i]);
        }
        return new ArrayList<>(mp.values());
    }
    //  boolean isAnagram(String s, String t) {
    //     HashMap<Character,Integer> mp1 = new HashMap<>();
    //     HashMap<Character,Integer> mp2 = new HashMap<>();

    //     if(s.length() != t.length()) return false;
    //     int n = s.length();

    //     for(int i=0; i<n; i++){
    //         mp1.put(s.charAt(i),mp1.getOrDefault(s.charAt(i),0)+1);
    //         mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0)+1);
    //     }

    //     for(int i=0; i<s.length();i++){
    //         mp2.put(s.charAt(i),mp2.getOrDefault(s.charAt(i),0)-1);
    //         if(mp2.get(s.charAt(i)) == 0) mp2.remove(s.charAt(i));

    //         mp1.put(t.charAt(i),mp1.getOrDefault(t.charAt(i),0)-1);
    //         if(mp1.get(t.charAt(i)) == 0) mp1.remove(t.charAt(i));
    //     }
    //     return mp1.isEmpty() && mp2.isEmpty();
    // }
}
