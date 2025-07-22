import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(String digit, String output, int index, List<String> ans, String[] mapping) {
        //base case
        if(index >= digit.length()) {
            ans.add(output);
            return;
        }

        int number = digit.charAt(index) - '0';
        String value = mapping[number];

        for(int i=0; i<value.length(); i++) {
            output += value.charAt(i);
            solve(digit, output, index+1, ans, mapping);
            output = output.substring(0, output.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0)
            return ans;
        String output = "";
        int index = 0;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        solve(digits, output, index, ans, mapping);
        return ans;
    }
}
