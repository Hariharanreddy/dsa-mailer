import java.util.ArrayList;
import java.util.List;

class Solution {
    // Recursive function to generate subsequences
    private void solve(List<String> ans, String str, String output, int i) {
        // Base case: if we've reached the end of the string
        if (i >= str.length()) {
            // If the output string is not empty, add it to the answer list
            if (output.length() > 0) {
                ans.add(output);
            }
            return;
        }

        // Exclude the current character
        solve(ans, str, output, i + 1);

        // Include the current character
        output += str.charAt(i);
        solve(ans, str, output, i + 1);
    }

    // Function to generate all subsequences of a string
    public List<String> subsequences(String str) {
        List<String> ans = new ArrayList<>(); // Initialize an ArrayList to store subsequences.
        String output = ""; // Initialize an empty string to build subsequences.
        solve(ans, str, output, 0); // Start the recursive function.
        return ans; // Return the list of subsequences.
    }
}
