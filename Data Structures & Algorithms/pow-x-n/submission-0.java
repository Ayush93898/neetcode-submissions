class Solution {
    public double myPow(double x, int n) {
        if(x == 1) return 1.0;

        long newN = Math.abs((long)n); 
        double ans = 1.0;
        while(newN > 0){
            if(newN % 2 == 1){ // odd pow - pow ek kam
                newN = newN - 1;
                ans = ans * x;
            }else{
                newN = newN / 2;
                x = x * x;
            }
        }
        return n < 0 ? 1.0/ans : ans;
    }
}
