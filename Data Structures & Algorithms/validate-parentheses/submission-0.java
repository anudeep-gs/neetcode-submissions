class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stk.push(c);
                    break;

                case ')':
                    if (stk.isEmpty() || stk.peek() != '(')
                        return false;
                    stk.pop();
                    break;

                case ']':
                    if (stk.isEmpty() || stk.peek() != '[')
                        return false;
                    stk.pop();
                    break;

                case '}':
                    if (stk.isEmpty() || stk.peek() != '{')
                        return false;
                    stk.pop();
                    break;
            }
        }

        return stk.isEmpty();
    }
}