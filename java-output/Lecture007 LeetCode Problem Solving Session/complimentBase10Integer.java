import java.util.*;
import java.lang.*;

class Solution {
    /**
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
     * @param n The input positive integer
     * @return The complement of n
     */
    public int bitwiseComplement(int n) {
        int m = n;
        int mask = 0;

        if (n == 0) {
            return 1;
        }

        while (m != 0) {
            mask = (mask << 1) | 1;
            m = m >> 1;
        }

        int ans = (~n) & mask;

        return ans;
    }
}
