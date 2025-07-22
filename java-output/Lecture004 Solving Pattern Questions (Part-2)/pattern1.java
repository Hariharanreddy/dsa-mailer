import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object for user input
        int n = scanner.nextInt(); // Read input from user

        int i = 1; // Initialize outer loop counter

        while (i <= n) { // Outer loop iterates 'n' times

            int j = 1; // Initialize inner loop counter

            while (j <= n) { // Inner loop iterates 'n' times
                System.out.print(n - j + 1); // Print the pattern
                j = j + 1; // Increment inner loop counter
            }
            System.out.println(); // Move to the next line after each row
            i = i + 1; // Increment outer loop counter
        }
        scanner.close(); //Close the scanner
    }
}
