class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if (n2 > n1)
            return "";
        int l = 0;
        int r = 0;
        int sIdx = -1;
        int eIdx = -1;
        int minLen = Integer.MAX_VALUE;

        int[] a1 = new int[128];
        for (int i = 0; i < n2; i++) a1[t.charAt(i)]++;

        int[] a2 = new int[128];
        for (int i = 0; i < r; i++) a2[s.charAt(i)]++;

        while (r < n1) {
            while (!check(a1, a2) && r < n1) {
                a2[s.charAt(r)]++;
                r++;
            }
            while (check(a1, a2)) {
                if (r - l < minLen) {
                    minLen = r - l;
                    sIdx = l;
                    eIdx = r - 1;
                }

                a2[s.charAt(l)]--;
                l++;
            }
        }

        if (sIdx == -1 || eIdx == -1)
            return "";
        return s.substring(sIdx, eIdx + 1);
    }
   boolean check(int[] a1, int[] a2) {
    for (int i = 0; i < 128; i++) {
        if (a2[i] < a1[i])
            return false;
    }
    return true;
}
}
