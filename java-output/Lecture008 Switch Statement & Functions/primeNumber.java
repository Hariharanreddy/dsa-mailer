import java.util.Scanner;

class PrimeChecker {

    // 0 -> Not a Prime number
    // 1 -> Prime number

    boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                // Divisible, not a prime number
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeChecker pc = new PrimeChecker();
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter a number: ");
        n = scanner.nextInt();
        if (pc.isPrime(n)) {
            System.out.println(" is a Prime number");
        } else {
            System.out.println("Not a prime number");
        }
        scanner.close();
    }
}
