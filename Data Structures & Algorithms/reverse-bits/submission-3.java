class Solution {
    public int reverseBits(int n) {
        int ans = 0 ;
        // int i=0;
        for(int i=0; i<32; i++){
            ans = ans + (n & 1) * (1 << (31 - i));
            n=n>>1;
            
        }
        return ans;
    }
}
