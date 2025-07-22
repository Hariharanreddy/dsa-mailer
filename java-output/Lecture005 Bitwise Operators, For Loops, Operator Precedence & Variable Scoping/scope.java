import java.util.*;

class Solution {
    /**
     * This method finds the maximum sum of a contiguous subarray within a given array.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of a contiguous subarray.
     */
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = solution.maxSubArray(nums);
        System.out.println("Maximum contiguous sum is: " + maxSum); // Output: 6


        int [] nums2 = {1};
        maxSum = solution.maxSubArray(nums2);
        System.out.println("Maximum contiguous sum is: " + maxSum); // Output: 1

        int [] nums3 = {5,4,-1,7,8};
        maxSum = solution.maxSubArray(nums3);
        System.out.println("Maximum contiguous sum is: " + maxSum); // Output: 23

        int [] nums4 = {-1};
        maxSum = solution.maxSubArray(nums4);
        System.out.println("Maximum contiguous sum is: " + maxSum); // Output: -1
    }
}
