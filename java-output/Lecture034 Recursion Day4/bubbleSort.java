import java.util.Arrays;

class Solution {

    // Method to sort an array using bubble sort recursively
    public void sortArray(int[] arr, int n) {
        // Base case: array is already sorted if it has 0 or 1 element
        if (n == 0 || n == 1) {
            return;
        }

        // Single pass to place the largest element at the end
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap elements using a temporary variable
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Recursive call to sort the remaining subarray
        sortArray(arr, n - 1);
    }


    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {2, 5, 1, 6, 9};

        obj.sortArray(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
