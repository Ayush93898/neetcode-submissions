class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxF = 0;
        int maxLen = 0;
        int l=0;
        int r=0;

        int[] freq = new int[26];
        while(r < n){
            freq[s.charAt(r)-'A']++;
            maxF = Math.max(maxF,findMax(freq));
            // int len = r-l+1;

            while((r-l+1)-maxF > k){
                freq[s.charAt(l)-'A']--;
                l++;
                maxF = Math.max(maxF,findMax(freq));
            }
            maxLen = Math.max(r-l+1,maxLen);
            r++;
        }
        return maxLen;
    }
    int findMax(int[] arr){
        int max = 0;
        for(int num: arr){
            if(num > max) max = num;
        }
        return max;
    }
    
}
