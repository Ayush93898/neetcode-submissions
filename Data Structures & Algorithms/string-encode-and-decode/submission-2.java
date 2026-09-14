class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (s.charAt(i) != '#') {
                i++;
            }
            String numLen = s.substring(j, i);
            int len = Integer.parseInt(numLen);
            String word = s.substring(i + 1, i + len + 1);
            ans.add(word);
            i = i + len + 1;
            j = i;
        }
        return ans;
    }
}
