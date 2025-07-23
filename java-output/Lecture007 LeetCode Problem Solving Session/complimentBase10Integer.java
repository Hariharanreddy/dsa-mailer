1. **What the Code Solves:**

This C++ code computes the **bitwise complement** of a given non-negative integer. The core problem is to find the complement of the binary representation of a number, flipping all bits but only up to the highest set bit.

---

2. **Problem Description:**

**Bitwise Complement Problem:**  
Given a non-negative integer `n`, return its bitwise complement. The bitwise complement is defined as flipping every bit in the binary representation of `n` starting from the least significant bit up to the most significant bit of `n`. Leading zeros beyond the most significant bit are not considered.

- If `n = 0`, its complement is `1` because the binary representation is `0` and flipping it results in `1`.
- For any other number, you flip all bits of `n` from bit 0 up to the bit of the leftmost set bit.

*Relevance:*  
This problem is commonly found in coding interviews and competitive programming as it involves understanding bitwise operations and masking techniques efficiently without resorting to string conversions. This operation is fundamental in low-level programming and systems programming as well.

---

3. **Examples:**

| Input | Binary Representation | Output | Explanation                                    |
|-------|------------------------|--------|------------------------------------------------|
| 5     | 0101                   | 2      | Flip bits: 0101 → 1010 (binary for 10); mask only 4 bits, so output 1010 & 1111 = 1010 (decimal 10 is wrong — check mask length carefully). Correct is mask 111 for 3 bits → complement = 010. The code masks for the highest bit length. So complement of 0101 (5) is 010 (2 decimal).|
| 0     | 0                      | 1      | Special case: complement of `0` is `1`.          |

Two precise examples:

- Input: 5 (binary 101) → Output: 2 (binary 010)
- Input: 0 → Output: 1

Another edge case:

- Input: 1 (binary 1) → Output: 0 (binary 0)

---

4. **Logic Explanation:**

- If `n` is zero, return 1 immediately (since complement of 0 is 1).
- Otherwise:
  1. Make a copy `m` of `n`.
  2. Initialize a mask as 0.
  3. Keep shifting the mask left by 1 and setting the least significant bit to 1 until all bits used in `m` (from MSB to LSB) are covered.
     - For example, for `n=5 (binary 101)`, mask becomes `111` (binary).
  4. Compute the bitwise complement of `n` using `~n`.
  5. Use bitwise AND `&` with the mask to restrict the complement bits only to the length of `n`’s binary representation.
- Return the masked complement, which is the answer.

**Pattern/Techniques:** Bitwise operations and mask creation.

**Optimization:**  
The loop runs proportional to the number of bits in `n` (effectively O(log n)).

**Time Complexity:** O(log n) — where n is the value of the input number because the number of bits needed to represent n is proportional to log n.

---

5. **Java Code:**

public class Solution {

    /**  
     * Returns the bitwise complement of a non-negative integer n.  
     * The complement flips bits from the least to the most significant bit of n.  
     * Special case: if n is 0, the complement is 1.  
     *  
     * @param n the input integer  
     * @return the bitwise complement of n  
     */
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1; // special case for zero
        }
        int m = n;
        int mask = 0;
        
        // Build mask with all bits set to 1 of the same length as n's binary length
        while (m != 0) {
            mask = (mask << 1) | 1;
            m >>= 1;
        }
        
        // Compute complement and mask it to the same bit length as n
        int ans = (~n) & mask;
        return ans;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int input1 = 5;
        System.out.println("Input: " + input1 + " Output: " + sol.bitwiseComplement(input1)); // Expected: 2
        
        int input2 = 0;
        System.out.println("Input: " + input2 + " Output: " + sol.bitwiseComplement(input2)); // Expected: 1

        int input3 = 1;
        System.out.println("Input: " + input3 + " Output: " + sol.bitwiseComplement(input3)); // Expected: 0
    }
}