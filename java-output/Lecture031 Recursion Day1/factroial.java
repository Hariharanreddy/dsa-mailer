import java.util.Scanner;

class Factorial {

    // Recursive function to calculate factorial
    static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive step: n! = n * (n-1)!
        int smallerProblem = factorial(n - 1);
        int biggerProblem = n * smallerProblem;

        return biggerProblem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();
        scanner.close();


        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return;
        }

        int ans = factorial(n);
        System.out.println("Factorial of " + n + " is: " + ans);
    }
}
