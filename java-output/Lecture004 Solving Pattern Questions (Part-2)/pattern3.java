import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Input the number of rows

        int row = 1; // Initialize row counter
        while (row <= n) { // Outer loop for rows

            int col = 1; // Initialize column counter
            while (col <= row) { // Inner loop for columns
                System.out.print(row); // Print the row number
                col = col + 1; // Increment column counter
            }
            System.out.println(); // Move to the next line after each row
            row = row + 1; // Increment row counter
        }
        scanner.close();
    }
}
