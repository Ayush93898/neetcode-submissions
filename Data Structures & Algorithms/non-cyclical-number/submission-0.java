class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> st = new HashSet<>();
        while(true){
            if(st.contains(findSqSum(n))) return false;
            if (findSqSum(n) == 1) return true;
            st.add(findSqSum(n));
            n=findSqSum(n);
        }
    }
    int findSqSum(int num){
        int ans = 0;
        while(num>0){
            int digit = num % 10;
            ans += digit*digit;
            num=num/10;
        }
        return ans;
    }
}
