```java
import java.util.Arrays;
import java.util.Scanner;

public class DSA {

    // Method to check if a target element is present in a 2D array
    public static boolean isPresent(int[][] arr, int target, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // Method to print the sum of each column
    public static void printColSum(int[][] arr, int row, int col) {
        System.out.print("Printing Column Sums -> ");
        for (int j = 0; j < col; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += arr[i][j];
            }
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    // Method to print the sum of each row
    public static void printRowSum(int[][] arr, int row, int col) {
        System.out.print("Printing Row Sums -> ");
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += arr[i][j];
            }
            System.out.print(sum + " ");
        }
        System.out.println();
    }

    // Method to find the row with the largest sum
    public static int largestRowSum(int[][] arr, int row, int col) {
        int maxi = Integer.MIN_VALUE;
        int rowIndex = -1;
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += arr[i][j];
            }
            if (sum > maxi) {
                maxi = sum;
                rowIndex = i;
            }
        }
        System.out.println("The maximum sum is " + maxi);
        return rowIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = 3;
        int col = 3;

        // Create a 2D array
        int[][] arr = new int[row][col];

        System.out.println("Enter the elements:");
        // Taking row-wise input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Printing the array:");
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


        int ansIndex = largestRowSum(arr, row, col);
        System.out.println("Max row is at index " + ansIndex);
        sc.close();
    }
}
```
