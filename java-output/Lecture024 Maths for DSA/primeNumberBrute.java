import java.util.Scanner;

class PrimeChecker {

    // Function to check if a number is prime
    static boolean isPrime(int n) {

        // Numbers less than or equal to 1 are not prime
        if (n <= 1) {
            return false;
        }

        // Iterate from 2 to n-1
        for (int i = 2; i < n; i++) {
            // If n is divisible by i, it's not prime
            if (n % i == 0) {
                return false;
            }
        }
        // If no divisors found, it's prime
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Enter an integer: ");
        n = scanner.nextInt();

        if (isPrime(n)) {
            System.out.println("It is a Prime Number");
        } else {
            System.out.println("It is not a Prime Number");
        }
        scanner.close();
    }
}
