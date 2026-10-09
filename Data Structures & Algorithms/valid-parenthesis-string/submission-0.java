class Solution {
    public boolean checkValidString(String s) {
        if(s.charAt(0) == ')') return false; // as we can't be balance

        // range -- bcz of '*' 
        int min = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                min++;
                max++;
            }
            else if(s.charAt(i) == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return min == 0;
    }
}