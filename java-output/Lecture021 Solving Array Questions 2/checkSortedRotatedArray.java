import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Checks if the input array can be made non-decreasing by at most one rotation.
     *
     * @param nums The input array of integers.
     * @return True if the array can be made non-decreasing by at most one rotation, false otherwise.
     */
    public boolean check(List<Integer> nums) {
        int cnt = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                cnt++;
            }
        }
        if (nums.get(nums.size() - 1) > nums.get(0)) {
            cnt++;
        }

        return cnt <= 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> nums1 = new ArrayList<>(List.of(1,2,3));
        List<Integer> nums2 = new ArrayList<>(List.of(2,1,3));
        List<Integer> nums3 = new ArrayList<>(List.of(3,1,2));

        System.out.println(sol.check(nums1)); //true
        System.out.println(sol.check(nums2)); //true
        System.out.println(sol.check(nums3)); //false

    }
}
