import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read input decimal number

        int i = 0; 
        int ans = 0;

        while (n != 0) {

            int digit = n % 10; // Extract the last digit

            if (digit == 1) {
                ans = ans + (int) Math.pow(2, i); // Add 2^i if digit is 1
            }

            n = n / 10; // Remove the last digit
            i++;
        }
        System.out.println(ans); // Print the binary equivalent
        scanner.close();
    }
}
