import java.util.Scanner;

public class SumCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input from the console.

        int n;
        System.out.print("Enter a positive integer: "); // Prompt the user to enter a positive integer.
        n = scanner.nextInt(); // Read the integer input from the user.

        int i = 1;
        int sum = 0;

        while (i <= n) { // Loop until i becomes greater than n.
            sum = sum + i; // Add the current value of i to sum.
            i = i + 1; // Increment i by 1.
        }

        System.out.println("The sum of integers from 1 to " + n + " is: " + sum); // Print the calculated sum.

        scanner.close(); // Close the Scanner to release resources.
    }
}
