import java.util.Scanner;

class Solution {

    // Function to find the integer square root of a number
    long long sqrtInteger(int n) {

        int s = 0;
        int e = n;
        long long mid = s + (e - s) / 2;

        long long ans = -1;
        while (s <= e) {

            long long square = mid * mid;

            if (square == n)
                return mid;

            if (square < n) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    // Function to find the square root with more precision
    double morePrecision(int n, int precision, int tempSol) {

        double factor = 1;
        double ans = tempSol;

        for (int i = 0; i < precision; i++) {
            factor = factor / 10;

            for (double j = ans; j * j < n; j = j + factor) {
                ans = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution obj = new Solution();
        System.out.println(" Enter the number ");
        int n = sc.nextInt();

        int tempSol = (int) obj.sqrtInteger(n); // Type casting is necessary here.
        System.out.println(" Answer is " + obj.morePrecision(n, 3, tempSol));

        sc.close();
    }
}
