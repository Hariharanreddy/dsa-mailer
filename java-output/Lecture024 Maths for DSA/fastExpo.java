import java.util.Scanner;

public class FastExpo {

    // Function to calculate (a raised to the power b) using binary exponentiation
    public static int fastExpo(int a, int b) {
        int res = 1; // Initialize result

        while (b > 0) {
            if ((b & 1) == 1) { // Check if b is odd
                res = res * a; // Multiply result by a if b is odd
            }
            b = b >> 1; // Divide b by 2 (right bit shift)
            a = a * a; // Square a
        }
        return res; // Return the result
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object to read input
        System.out.println("Enter the values of a and b"); // Prompt the user to enter values
        int a = sc.nextInt(); // Read the value of a
        int b = sc.nextInt(); // Read the value of b
        System.out.println("Answer is: " + fastExpo(a, b)); // Print the result
        sc.close(); // Close the Scanner
    }
}
