import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String str = "babbar"; // Input string

        Stack<Character> s = new Stack<>(); // Stack to store characters

        // Push each character of the string onto the stack
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            s.push(ch);
        }

        String ans = ""; // String to store the reversed string

        // Pop each character from the stack and append it to the reversed string
        while (!s.empty()) {
            char ch = s.pop();
            ans += ch; // Equivalent to ans.push_back(ch) in C++
        }

        System.out.println("answer is: " + ans); // Print the reversed string
    }
}
