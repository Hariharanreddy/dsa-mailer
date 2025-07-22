import java.util.Arrays;

class Solution {

    // Function to find the pivot element in a sorted and rotated array
    public int getPivot(int[] arr, int n) {

        // Initialize start and end pointers
        int s = 0;
        int e = n - 1;
        int mid;

        // Binary search to find the pivot
        while (s < e) {

            // Calculate the middle index
            mid = s + (e - s) / 2;

            // If the middle element is greater than or equal to the first element
            // then the pivot lies in the right half
            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            }
            // Otherwise, the pivot lies in the left half
            else {
                e = mid;
            }
            // Recalculate the middle index
            mid = s + (e - s) / 2;
        }
        // Return the pivot index
        return s;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {1, 3, 8, 10, 17};
        System.out.println("Pivot is " + obj.getPivot(arr, arr.length));
    }
}
