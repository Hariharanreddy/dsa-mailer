import java.util.Scanner;
import java.lang.Math;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read input from the user.

        int ans = 0;
        int i = 0;
        while (n != 0) {

            int bit = n & 1; // Extract the least significant bit.

            ans = (int) (bit * Math.pow(10, i)) + ans; // Add the bit to the result.

            n = n >> 1; // Right-shift n by 1 bit.
            i++;

        }

        System.out.println("Answer is " + ans); // Print the result.
        scanner.close();
    }
}
