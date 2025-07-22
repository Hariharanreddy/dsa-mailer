import java.util.Vector;

class Solution {
    /**
     * Finds the duplicate number in an array using XOR operation.
     * @param arr The input array of integers.
     * @return The duplicate number in the array.
     */
    public int findDuplicate(Vector<Integer> arr) {
        int ans = 0;

        // XORing all array elements
        for (int i = 0; i < arr.size(); i++) {
            ans = ans ^ arr.get(i);
        }

        // XORing numbers from 1 to n-1 (n is the size of the array)
        for (int i = 1; i < arr.size(); i++) {
            ans = ans ^ i;
        }
        return ans;
    }
}
