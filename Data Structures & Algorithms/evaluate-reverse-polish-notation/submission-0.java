class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        // int val = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")
                || tokens[i].equals("/")) {
                int a = (stack.pop());
                int b = (stack.pop());
                int val = 0;

                if (tokens[i].equals("+"))
                    val = b + a;
                else if (tokens[i].equals("-"))
                    val = b - a;
                else if (tokens[i].equals("*"))
                    val = a * b;
                else
                    val = b / a;

                stack.push(val);
            } else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }
}
