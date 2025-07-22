import java.lang.Math;

class Solution {
    /**
     * Calculates the difference between the product and sum of digits of a number.
     *
     * @param n The input integer.
     * @return The difference between the product and sum of digits.
     */
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            prod = prod * digit;
            sum = sum + digit;
            n = n / 10;
        }

        int answer = prod - sum;
        return answer;
    }
}
