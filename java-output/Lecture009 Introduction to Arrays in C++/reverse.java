import java.util.Arrays;

public class ReverseArray {

    // Function to reverse an array
    public static void reverse(int[] arr, int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            // Swapping elements using a temporary variable
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to print an array
    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 0, 5, -2, 15};
        int[] brr = {2, 6, 3, 9, 4};

        reverse(arr, arr.length);
        reverse(brr, brr.length);

        printArray(arr, arr.length);
        printArray(brr, brr.length);
    }
}
