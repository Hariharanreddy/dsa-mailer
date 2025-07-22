import java.util.Arrays;

class Solution {
    // Function to check if it is possible to place k cows in stalls such that the minimum distance between any two cows is at least mid
    boolean isPossible(int[] stalls, int k, int mid, int n) {
        int cowCount = 1; // Initialize the count of cows placed
        int lastPos = stalls[0]; // Initialize the last position of a cow

        // Iterate over the stalls
        for (int i = 1; i < n; i++) {
            // Check if it is possible to place a cow at the current stall such that the minimum distance is at least mid
            if (stalls[i] - lastPos >= mid) {
                cowCount++; // Increment the count of cows placed
                // If the required number of cows have been placed, return true
                if (cowCount == k) {
                    return true;
                }
                lastPos = stalls[i]; // Update the last position of a cow
            }
        }
        // If the required number of cows could not be placed, return false
        return false;
    }

    // Function to find the maximum minimum distance between any two cows
    int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort the stalls in ascending order
        int s = 0; // Initialize the start of the search space
        int n = stalls.length; // Get the number of stalls
        int e = stalls[n - 1]; // Initialize the end of the search space
        int ans = -1; // Initialize the answer to -1
        int mid = s + (e - s) / 2; // Initialize the middle of the search space

        // Perform binary search to find the maximum minimum distance
        while (s <= e) {
            // Check if it is possible to place k cows with the current minimum distance
            if (isPossible(stalls, k, mid, n)) {
                ans = mid; // Update the answer
                s = mid + 1; // Move the start of the search space to the right
            } else {
                e = mid - 1; // Move the end of the search space to the left
            }
            mid = s + (e - s) / 2; // Update the middle of the search space
        }
        // Return the maximum minimum distance
        return ans;
    }
}
