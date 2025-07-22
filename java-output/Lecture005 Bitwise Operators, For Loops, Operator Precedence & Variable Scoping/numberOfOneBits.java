import java.lang.*;

class Solution {
    /**
     * Counts the number of set bits (1s) in the binary representation of an integer.
     *
     * @param n The input integer.
     * @return The number of set bits in n.
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //checking last bit
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
