class Solution {
    static String[] phone = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[] digitArr = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            digitArr[i] = phone[digit];
        }

        solve(0, digitArr, ans, new StringBuilder());
        return ans;
    }
    void solve(int index,  String[] digitArr, List<String> ans, StringBuilder sb){
        if(index == digitArr.length){
            ans.add(sb.toString());
            return;
        }
        for(int i=0; i<digitArr[index].length(); i++){
            sb.append(digitArr[index].charAt(i));
            solve(index+1,digitArr,ans,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
