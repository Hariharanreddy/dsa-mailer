import java.util.Arrays;

class Solution {
    // Function to find the pivot element in a rotated sorted array
    int getPivot(int[] arr, int n) {
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;

        while (s < e) {
            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid = s + (e - s) / 2;
        }
        return s;
    }

    // Function to perform binary search on a sorted array
    int binarySearch(int[] arr, int s, int e, int key) {
        int start = s;
        int end = e;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == key) {
                return mid;
            }
            //go to right wala part
            if (key > arr[mid]) {
                start = mid + 1;
            } else { //key < arr[mid]
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return -1;
    }

    // Function to find the position of an element k in a rotated sorted array
    int findPosition(int[] arr, int n, int k) {
        int pivot = getPivot(arr, n);
        if (k >= arr[pivot] && k <= arr[n - 1]) {
            //BS on second line
            return binarySearch(arr, pivot, n - 1, k);
        } else {
            //BS on first line
            return binarySearch(arr, 0, pivot - 1, k);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {5,6,7,8,9,1,2,3};
        int n = arr.length;
        int k = 3;
        int result = sol.findPosition(arr, n, k);
        System.out.println("The position of " + k + " in the array is: " + result);
    }
}
