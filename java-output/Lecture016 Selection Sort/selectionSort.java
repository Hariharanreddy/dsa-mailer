import java.util.Arrays;

public class SelectionSort {

    // Function to implement selection sort algorithm
    public static void selectionSort(int[] arr, int n) {
        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            // Initialize the minimum index to the current index
            int minIndex = i;

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the minimum element with the current element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int n = arr.length;
        selectionSort(arr, n);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
