import java.lang.Integer;

class Solution {
    /**
     * Reverses a 32-bit signed integer.
     *
     * @param x The integer to reverse.
     * @return The reversed integer, or 0 if the reversed integer overflows.
     */
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int digit = x % 10;
            //Check for overflow before multiplication
            if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            ans = (ans * 10) + digit;
            x = x / 10;
        }
        return ans;
    }
}
