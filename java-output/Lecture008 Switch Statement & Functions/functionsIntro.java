import java.util.Scanner;

public class PowerCalculator {

    // Method to calculate a raised to the power b
    public static int power(int a, int b) {
        int ans = 1;
        for (int i = 1; i <= b; i++) {
            ans = ans * a;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get inputs for the first calculation
        System.out.print("Enter the base (a) and exponent (b): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Calculate and print the result
        int result1 = power(a, b);
        System.out.println("Answer is " + result1);


        // Get inputs for the second calculation
        System.out.print("Enter the base (c) and exponent (d): ");
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        // Calculate and print the result
        int result2 = power(c, d);
        System.out.println("Answer is " + result2);


        // Get inputs for the third calculation
        System.out.print("Enter the base (e) and exponent (f): ");
        int e = scanner.nextInt();
        int f = scanner.nextInt();

        // Calculate and print the result
        int result3 = power(e, f);
        System.out.println("Answer is " + result3);

        scanner.close();
    }
}
