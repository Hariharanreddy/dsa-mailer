import java.util.Scanner;

public class TwoDArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int row;
        System.out.print("Enter the number of rows: ");
        row = scanner.nextInt();

        int col;
        System.out.print("Enter the number of columns: ");
        col = scanner.nextInt();

        // Creating a 2D array dynamically
        int[][] arr = new int[row][col];

        // Taking input
        System.out.println("Enter the elements:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // Taking output
        System.out.println("\nThe matrix is:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close(); //Close scanner to prevent resource leak

        //No need to explicitly release memory in Java. Garbage collection handles it.

    }
}
