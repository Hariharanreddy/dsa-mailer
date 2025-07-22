import java.util.Arrays;

class Solution {
    // Function to find the first occurrence of a key in a sorted array
    int firstOcc(int[] arr, int n, int key) {
        int s = 0, e = n - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (arr[mid] == key) {
                ans = mid;
                e = mid - 1; // Search in the left half for more occurrences
            } else if (key > arr[mid]) { // If key is greater, search in the right half
                s = mid + 1;
            } else { // If key is smaller, search in the left half
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    // Function to find the last occurrence of a key in a sorted array
    int lastOcc(int[] arr, int n, int key) {
        int s = 0, e = n - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (arr[mid] == key) {
                ans = mid;
                s = mid + 1; // Search in the right half for more occurrences
            } else if (key > arr[mid]) { // If key is greater, search in the right half
                s = mid + 1;
            } else { // If key is smaller, search in the left half
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    // Function to find the first and last positions of a key in a sorted array
    int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOcc(arr, n, k);
        int last = lastOcc(arr, n, k);
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 6};
        int n = arr.length;
        int k = 4;
        int[] result = sol.firstAndLastPosition(arr, n, k);
        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);

    }
}
