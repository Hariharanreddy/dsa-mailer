import java.util.Arrays;

class Solution {
    /**
     * Rotates the given array by k positions to the right.
     * Uses a temporary array to store the rotated elements.
     * @param nums The array to be rotated.
     * @param k The number of positions to rotate by.
     */
    public void rotate(int[] nums, int k) {
        //Handle cases where k is larger than the array size.
        k = k % nums.length;
        int n = nums.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
