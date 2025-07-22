import java.util.Scanner;

public class PrintNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input from the console
        int n = scanner.nextInt(); // Read the input integer n

        int i = 1; // Initialize the counter i

        while (i <= n) { // Loop until i becomes greater than n

            System.out.print(i + " "); // Print the current value of i followed by a space
            i = i + 1; // Increment i by 1
        }
        scanner.close(); // Close the scanner to release resources.
    }
}
