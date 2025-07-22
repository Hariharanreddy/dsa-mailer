import java.util.Scanner;

class SieveOfEratosthenes {

    // Function to implement Sieve of Eratosthenes algorithm
    public void sieve(boolean[] prime) {
        // Initially assume all numbers are prime
        for (int i = 2; i <= 1000000; i++) {
            prime[i] = true;
        }

        // Iterate through numbers and mark non-prime numbers
        for (int i = 2; i <= 1000000; i++) {
            if (prime[i]) {
                // Mark multiples of i as non-prime
                for (int j = 2 * i; j <= 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }
        // 0 and 1 are not prime
        prime[0] = prime[1] = false;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes obj = new SieveOfEratosthenes();
        boolean[] prime = new boolean[1000001]; // Array to store prime numbers

        // Generate prime numbers using Sieve of Eratosthenes
        obj.sieve(prime);

        Scanner scanner = new Scanner(System.in);
        int n;

        // Read input numbers and check if they are prime
        System.out.print("Enter a number (-1 to exit): ");
        n = scanner.nextInt();
        while (n != -1) {
            if (prime[n]) {
                System.out.println("It is a Prime Number");
            } else {
                System.out.println("It is not a Prime Number");
            }
            System.out.print("Enter a number (-1 to exit): ");
            n = scanner.nextInt();
        }
        scanner.close();
    }
}
