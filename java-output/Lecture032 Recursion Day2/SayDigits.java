import java.util.Scanner;

public class SayDigit {

    // Method to convert digits of a number to words recursively
    public static void sayDigit(int n, String[] arr) {

        // Base case: if the number is 0, return
        if (n == 0) {
            return;
        }

        // Processing: extract the last digit
        int digit = n % 10;
        n = n / 10;

        // Recursive call: process the remaining digits
        sayDigit(n, arr);

        // Print the word corresponding to the current digit
        System.out.print(arr[digit] + " ");
    }

    public static void main(String[] args) {

        // Array to store the words for digits 0-9
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        // Get input from the user
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();

        // Print some empty lines for better formatting
        System.out.println("\n\n\n");

        // Call the recursive method to print the digits as words
        sayDigit(n, arr);

        // Print some empty lines for better formatting
        System.out.println("\n\n\n");
    }
}
