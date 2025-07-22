```java
import java.util.Arrays;

class MergeSort {

    // Merge two sorted subarrays of arr[]
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int[] arr, int s, int e) {
        // Find the middle point
        int mid = (s + e) / 2;

        // Find sizes of two subarrays to be merged
        int len1 = mid - s + 1;
        int len2 = e - mid;

        // Create temp arrays
        int[] first = new int[len1];
        int[] second = new int[len2];

        // Copy data to temp arrays
        int mainArrayIndex = s;
        for (int i = 0; i < len1; i++) {
            first[i] = arr[mainArrayIndex++];
        }

        mainArrayIndex = mid + 1;
        for (int i = 0; i < len2; i++) {
            second[i] = arr[mainArrayIndex++];
        }

        // Initial indexes of first and second subarrays
        int index1 = 0;
        int index2 = 0;
        mainArrayIndex = s;

        // Merge the temp arrays
        while (index1 < len1 && index2 < len2) {
            if (first[index1] < second[index2]) {
                arr[mainArrayIndex++] = first[index1++];
            } else {
                arr[mainArrayIndex++] = second[index2++];
            }
        }

        // Copy remaining elements of first[], if any
        while (index1 < len1) {
            arr[mainArrayIndex++] = first[index1++];
        }

        // Copy remaining elements of second[], if any
        while (index2 < len2) {
            arr[mainArrayIndex++] = second[index2++];
        }
    }


    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(int[] arr, int s, int e) {
        // Base Case
        if (s >= e) {
            return;
        }

        // Find the middle point
        int mid = (s + e) / 2;

        // Sort first and second halves
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);

        // Merge the sorted halves
        merge(arr, s, e);
    }


    public static void main(String[] args) {
        MergeSort ob = new MergeSort();
        int[] arr = {3, 7, 0, 1, 5, 8, 3, 2, 34, 66, 87, 23, 12, 12, 12};
        int n = arr.length;

        ob.mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
```
