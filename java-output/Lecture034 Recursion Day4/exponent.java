import java.util.Scanner;

class PowerCalculator {

    // Method to calculate a raised to the power b recursively
    public int power(int a, int b) {
        // Base case: if b is 0, return 1
        if (b == 0) {
            return 1;
        }

        // Base case: if b is 1, return a
        if (b == 1) {
            return a;
        }

        // Recursive call: calculate power(a, b/2)
        int ans = power(a, b / 2);

        // If b is even
        if (b % 2 == 0) {
            return ans * ans;
        } else {
            // If b is odd
            return a * ans * ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base (a): ");
        int a = scanner.nextInt();
        System.out.print("Enter the exponent (b): ");
        int b = scanner.nextInt();
        System.out.println();

        PowerCalculator pc = new PowerCalculator();
        int ans = pc.power(a, b);

        System.out.println("Answer is " + ans);
        scanner.close();
    }
}
