class Solution {
    public boolean isValid(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;
        Deque<Character> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (!st.isEmpty() && ch == ')') {
                if (st.peek() != '(')
                    return false;
                else
                    st.pop();
            } else if (!st.isEmpty() && ch == ']') {
                if (st.peek() != '[')
                    return false;
                else
                    st.pop();
            } else if (!st.isEmpty() && ch == '}') {
                if (st.peek() != '{')
                    return false;
                else
                    st.pop();
            } else
                return false;
        }
        return st.size() == 0;
    }
}