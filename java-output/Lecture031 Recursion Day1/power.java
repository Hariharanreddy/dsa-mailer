import java.util.Scanner;

class PowerCalculator {

    // Method to calculate 2 raised to the power n recursively
    public int power(int n) {
        // Base case: 2^0 = 1
        if (n == 0) {
            return 1;
        }
        // Recursive relation: 2^n = 2 * 2^(n-1)
        return 2 * power(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PowerCalculator calculator = new PowerCalculator();

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int ans = calculator.power(n);

        System.out.println("2 raised to the power " + n + " is: " + ans);
        scanner.close();
    }
}
