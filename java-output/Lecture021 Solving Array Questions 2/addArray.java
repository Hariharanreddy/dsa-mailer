import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    // Function to reverse a vector/ArrayList
    private List<Integer> reverse(List<Integer> v) {
        int s = 0;
        int e = v.size() - 1;

        while (s < e) {
            int temp = v.get(s);
            v.set(s, v.get(e));
            v.set(e, temp);
            s++;
            e--;
        }
        return v;
    }

    // Function to find the sum of two arrays
    public List<Integer> findArraySum(List<Integer> a, int n, List<Integer> b, int m) {
        int i = n - 1;
        int j = m - 1;
        List<Integer> ans = new ArrayList<>();
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int val1 = a.get(i);
            int val2 = b.get(j);

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
            j--;
        }

        // First case: remaining elements in 'a'
        while (i >= 0) {
            int sum = a.get(i) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
        }

        // Second case: remaining elements in 'b'
        while (j >= 0) {
            int sum = b.get(j) + carry;
            carry = sum / 10;
            int value = sum % 10;
            ans.add(value);
            j--;
        }

        // Third case: remaining carry
        while (carry != 0) {
            int sum = carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
        }

        return reverse(ans);
    }
}
