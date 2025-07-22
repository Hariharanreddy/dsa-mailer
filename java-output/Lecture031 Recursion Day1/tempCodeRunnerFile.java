public class Solution {
    /**
     * Recursive function to calculate factorial.
     * @param n The non-negative integer for which to calculate the factorial.
     * @return The factorial of n.  Returns 1 if n is 0.
     */
    public int factorial(int n) {
        //Base case: if n is 0, return 1
        if (n == 0) {
            return 1;
        }
        //Recursive step: otherwise, return n * factorial(n-1)
        return n * factorial(n - 1);

    }
}
