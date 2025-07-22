import java.util.Arrays;

class Solution {
    /**
     * Finds the pivot index in a mountain array.
     * A mountain array is an array that increases strictly to a peak, then decreases strictly.
     * The pivot index is the index of the peak element.
     *
     * @param v The mountain array.
     * @return The pivot index.
     */
    public int find_pivot(int[] v) {
        int s = 0, e = v.length - 1;
        int mid = (s + e) / 2;
        while (s < e) {
            if (v[mid] < v[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid = (s + e) / 2;
        }
        return s;
    }

    /**
     * Finds the peak index in a mountain array.
     * This method uses the find_pivot method to find the peak index.
     *
     * @param arr The mountain array.
     * @return The peak index.
     */
    public int peakIndexInMountainArray(int[] arr) {
        return find_pivot(arr);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0,1,0};
        int peakIndex = sol.peakIndexInMountainArray(arr);
        System.out.println("Peak index: " + peakIndex); //Output: Peak index: 1

        int[] arr2 = {0,2,1,0};
        peakIndex = sol.peakIndexInMountainArray(arr2);
        System.out.println("Peak index: " + peakIndex); //Output: Peak index: 1

        int[] arr3 = {0,10,5,2};
        peakIndex = sol.peakIndexInMountainArray(arr3);
        System.out.println("Peak index: " + peakIndex); //Output: Peak index: 1

    }
}
