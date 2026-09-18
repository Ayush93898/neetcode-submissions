class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1 > n2) return false;
        int[] freq1 = new int[26];
        
        for(char ch : s1.toCharArray()) freq1[ch-'a']++;

        int l=0;
        int r = n1-1;
        int[] freq2 = new int[26];
        for(int i=0; i<=r; i++){
            freq2[s2.charAt(i)-'a']++;
        }
        while(r<n2-1){
            if(Arrays.equals(freq1,freq2)) return true;
            freq2[s2.charAt(l)-'a']--;
            l++;
            r++;
            freq2[s2.charAt(r)-'a']++;
        }
        if (Arrays.equals(freq1, freq2)) return true;
        return false;
    }
}
