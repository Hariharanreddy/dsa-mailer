import java.util.*;

class Solution {
    /**
     * Given an array of integers and a target sum, find all pairs of numbers in the array that add up to the target sum.
     *
     * @param arr The input array of integers.
     * @param s The target sum.
     * @return A list of lists, where each inner list contains a pair of numbers that add up to the target sum.  The pairs are sorted in ascending order, and within each pair, the smaller number comes first.
     */
    public List<List<Integer>> pairSum(int[] arr, int s) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(Math.min(arr[i], arr[j]));
                    temp.add(Math.max(arr[i], arr[j]));
                    ans.add(temp);
                }
            }
        }
        Collections.sort(ans, (a, b) -> {
            if(a.get(0) != b.get(0)) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });
        return ans;
    }
}
