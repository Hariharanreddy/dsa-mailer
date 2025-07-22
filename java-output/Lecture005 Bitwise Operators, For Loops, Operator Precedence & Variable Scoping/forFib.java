import java.util.*;
public class FibonacciSeries {

    // Main method
    public static void main(String[] args) {

        int n = 10; // Number of Fibonacci numbers to generate

        int a = 0; // First Fibonacci number
        int b = 1; // Second Fibonacci number

        System.out.print(a + " " + b + " "); // Print the first two Fibonacci numbers

        for (int i = 1; i <= n; i++) {

            int nextNumber = a + b; // Calculate the next Fibonacci number
            System.out.print(nextNumber + " "); // Print the next Fibonacci number

            a = b; // Update a
            b = nextNumber; // Update b
        }
    }
}
