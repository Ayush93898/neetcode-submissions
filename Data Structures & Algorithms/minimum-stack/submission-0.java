class MinStack {
    public record Pair(int first, int second) {
    }

    Deque<Pair> st;

    public MinStack() {
        st = new ArrayDeque<>();
    }

    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value,value));
        }else{
            int min = Math.min(value, st.peek().second());
            st.push(new Pair(value,min));
        }
    }

    public void pop() {
        if (!st.isEmpty()) { 
            st.pop();
        }
    }

    public int top() {
        return st.peek().first();
    }

    public int getMin() {
        return st.peek().second();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */