import java.util.Arrays;
import java.util.Scanner;

public class DSACode {

    // Method to calculate the sum of elements in an array
    public static int getSum(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of the array: ");
        n = sc.nextInt();

        //variable size array
        int[] arr = new int[n];

        //taking input in array
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = getSum(arr, n);

        System.out.println("answer is " + ans);

        //case 1: Infinite loop - will cause StackOverflowError
        //while (true) {
        //    int i = 5;
        //}

        //case 2: Infinite loop allocating memory - will cause OutOfMemoryError
        //while (true) {
        //    int[] ptr = new int[1]; // Allocate a small array to demonstrate memory usage
        //}
        sc.close();
    }
}
