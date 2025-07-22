import java.util.Stack;
import java.util.Vector;

class Solution {
    /**
     * Finds the next smaller element for each element in an array.
     *
     * @param arr The input array of integers.
     * @param n The size of the input array.
     * @return A vector containing the next smaller element for each element in the input array.
     */
    public Vector<Integer> nextSmallerElement(Vector<Integer> arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        Vector<Integer> ans = new Vector<>(n);

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr.get(i);
            while (s.peek() >= curr) {
                s.pop();
            }
            // ans is stack ka top
            ans.set(i, s.peek());
            s.push(curr);
        }
        return ans;
    }
}
