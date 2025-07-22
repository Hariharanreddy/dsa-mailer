import java.util.Arrays;

class Solution {

    // Function to print a portion of an array
    static void print(int[] arr, int s, int e) {
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Recursive function to perform binary search
    static boolean binarySearch(int[] arr, int s, int e, int k) {
        // Base case: element not found
        if (s > e) {
            return false;
        }

        int mid = s + (e - s) / 2; // Calculate the middle index

        // Element found
        if (arr[mid] == k) {
            return true;
        }

        // Search in the right half
        if (arr[mid] < k) {
            return binarySearch(arr, mid + 1, e, k);
        }
        // Search in the left half
        else {
            return binarySearch(arr, s, mid - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 10, 14, 18, 22, 38, 49, 55, 222};
        int size = arr.length;
        int key = 222;

        System.out.println("Present or not " + binarySearch(arr, 0, size - 1, key));
    }
}
