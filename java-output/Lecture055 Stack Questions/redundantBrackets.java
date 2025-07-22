import java.util.Stack;

class Solution {
    /**
     * Checks if a given expression string has redundant brackets.
     *
     * @param s The input expression string.
     * @return True if the expression has redundant brackets, False otherwise.
     */
    public boolean findRedundantBrackets(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            } else {
                // ch is either ')' or a lowercase letter

                if (ch == ')') {
                    boolean isRedundant = true;

                    while (st.peek() != '(') {
                        char top = st.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            isRedundant = false;
                        }
                        st.pop();
                    }

                    if (isRedundant) {
                        return true;
                    }
                    st.pop();
                }

            }
        }
        return false;
    }
}
