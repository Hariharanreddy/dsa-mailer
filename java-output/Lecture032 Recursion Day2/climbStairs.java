## 1. **Identify the Core DSA Problem:**
The code solves the **"Climbing Stairs"** problem, a classic dynamic programming problem.

## 2. **Problem Statement:**
**Problem:** Given a staircase with `n` stairs, find the number of distinct ways you can climb to the top. At each step, you can either climb 1 or 2 stairs.

**Context:** This problem is relevant in both real-world scenarios (e.g., designing paths with limited options) and competitive programming challenges, where it tests dynamic programming skills.

## 3. **Sample Input/Output Pairs:**
- **Example 1:**  
  Input: `nStairs = 4`  
  Output: `5`  
  Explanation: The distinct ways to climb 4 stairs are: `[1,1,1,1], [1,1,2], [1,2,1], [2,1,1], [2,2]`.

- **Example 2:**  
  Input: `nStairs = 3`  
  Output: `3`  
  Explanation: The distinct ways to climb 3 stairs are: `[1,1,1], [1,2], [2,1]`.

## 4. **Logic Explanation:**
- **Base Cases:**
  - If `nStairs` is less than 0, return 0 (no valid way to climb).
  - If `nStairs` equals 0, return 1 (you are already at the top).

- **Recursive Case:**
  - The number of distinct ways to climb `nStairs` is the sum of the ways to climb `nStairs-1` (by taking one step up) and `nStairs-2` (by taking two steps up).

- **Optimization:** The recursive approach leads to exponential time complexity due to repeated calculations. To optimize, use dynamic programming to store and reuse the results of subproblems.

- **Time Complexity:** Without optimization, the time complexity is exponential (O(2^n)), but with dynamic programming, it reduces to O(n).

## 5. **Java Implementation:**
To improve efficiency, we'll use dynamic programming instead of naive recursion.

```java
public class ClimbingStairs {
    /**
     * Calculates the distinct ways to climb n stairs.
     * 
     * @param nStairs The total number of stairs to climb.
     * @return The number of distinct ways to climb.
     */
    public int countDistinctWaysToClimbStair(int nStairs) {
        if (nStairs < 0) {
            return 0;
        }
        if (nStairs == 0) {
            return 1;
        }

        int[] ways = new int[nStairs + 1];
        ways[0] = 1;

        if (nStairs >= 1) {
            ways[1] = 1;
        }

        for (int i = 2; i <= nStairs; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[nStairs];
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        System.out.println("Distinct ways to climb 4 stairs: " + cs.countDistinctWaysToClimbStair(4));
        System.out.println("Distinct ways to climb 3 stairs: " + cs.countDistinctWaysToClimbStair(3));
    }
}
```