import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Reverses a string in-place using two pointers.
     * @param s The string to be reversed (represented as a list of characters).
     */
    public void reverseString(List<Character> s) {
        int st = 0;
        int e = s.size() - 1;

        while (st < e) {
            char temp = s.get(st);
            s.set(st, s.get(e));
            s.set(e, temp);
            st++;
            e--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Character> str = new ArrayList<>();
        str.add('h');
        str.add('e');
        str.add('l');
        str.add('l');
        str.add('o');
        sol.reverseString(str);
        System.out.println(str); //Output: [o, l, l, e, h]

    }
}
