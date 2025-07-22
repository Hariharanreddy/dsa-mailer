import java.util.Scanner;

public class PrintNumbers {

    // Recursive function to print numbers from 1 to n
    public static void print(int n) {
        // Base case: if n is 0, return
        if (n == 0) {
            return;
        }

        // Recursive step: print numbers from 1 to n-1
        print(n - 1);

        // Print the current number n
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Enter a number: ");
        n = scanner.nextInt();
        System.out.println(); //Adding a new line for better output formatting

        print(n);

        scanner.close();
    }
}
