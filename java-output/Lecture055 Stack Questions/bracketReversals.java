import java.util.Stack;

class Solution {
    /**
     * Finds the minimum cost to balance curly braces in a string.
     *
     * @param str The input string containing curly braces.
     * @return The minimum cost, or -1 if the string length is odd.
     */
    public int findMinimumCost(String str) {
        // Odd condition
        if (str.length() % 2 == 1) {
            return -1;
        }

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '{') {
                s.push(ch);
            } else {
                // ch is closed brace
                if (!s.empty() && s.peek() == '{') {
                    s.pop();
                } else {
                    s.push(ch);
                }
            }
        }

        // Stack contains invalid expression
        int a = 0, b = 0;
        while (!s.empty()) {
            if (s.peek() == '{') {
                b++;
            } else {
                a++;
            }
            s.pop();
        }

        int ans = (a + 1) / 2 + (b + 1) / 2;
        return ans;
    }
}
