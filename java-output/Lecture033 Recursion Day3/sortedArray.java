import java.util.Arrays;

class Solution {

    // Recursive function to check if an array is sorted
    boolean isSorted(int[] arr, int size) {
        // Base case: An array with 0 or 1 element is considered sorted
        if (size == 0 || size == 1) {
            return true;
        }

        // If the first element is greater than the second, the array is not sorted
        if (arr[0] > arr[1]) {
            return false;
        } else {
            // Recursively check the remaining part of the array
            boolean remainingPart = isSorted(Arrays.copyOfRange(arr, 1, arr.length), size - 1);
            return remainingPart;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution(); //Creating object of the class
        int[] arr = {2, 4, 9, 9, 9};
        int size = arr.length;

        boolean ans = obj.isSorted(arr, size);

        if (ans) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
}
