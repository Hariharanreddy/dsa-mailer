import java.lang.Integer;

class Solution {
    /**
     * Checks if a given integer is a power of two.
     *
     * @param n The integer to check.
     * @return True if n is a power of two, false otherwise.
     */
    public boolean isPowerOfTwo(int n) {
        int ans = 1;

        for (int i = 0; i <= 30; i++) {
            //System.out.println(" ans " + ans); //for debugging
            if (ans == n) {
                return true;
            }
            if (ans < Integer.MAX_VALUE / 2) {
                ans = ans * 2;
            }

        }
        return false;
    }
}
