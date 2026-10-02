class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = n;
        int close = n;
    
        solve(open,close,ans,new StringBuilder());
        return ans;
    }
    void solve(int open, int close, List<String> ans, StringBuilder sb){
        if(open ==0 && close ==0){
            ans.add(sb.toString());
            return;
        }
        if(open!=0){
            sb.append("(");
            solve(open-1,close,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close != 0 && close > open){
            sb.append(")");
            solve(open,close-1,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}