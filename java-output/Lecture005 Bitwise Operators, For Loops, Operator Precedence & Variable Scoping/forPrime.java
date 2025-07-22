import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = scanner.nextInt();

        boolean isPrime = true; // Initialize isPrime to true

        for (int i = 2; i < n; i++) {

            // If n is divisible by i, it's not a prime number
            if (n % i == 0) {
                isPrime = false;
                break; // Exit the loop since we know it's not prime
            }
        }

        if (!isPrime) {
            System.out.println("Not a Prime Number");
        } else {
            System.out.println("is a Prime Number");
        }
        scanner.close();
    }
}
