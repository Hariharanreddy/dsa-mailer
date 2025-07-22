import java.util.Stack;

class Solution {
    /**
     * Checks if the given expression containing parentheses is valid.
     *
     * @param expression The expression string to check.
     * @return True if the expression is valid, false otherwise.
     */
    public boolean isValidParenthesis(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If opening bracket, push onto stack
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // For closing bracket
                if (!s.empty()) {
                    char top = s.peek();
                    if ((ch == ')' && top == '(') ||
                            (ch == '}' && top == '{') ||
                            (ch == ']' && top == '[')) {
                        s.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        // If stack is empty, all parentheses are matched
        return s.empty();
    }
}
