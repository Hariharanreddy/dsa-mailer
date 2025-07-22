import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Finds the intersection of two sorted arrays.
     *
     * @param arr1 The first sorted array.
     * @param n The size of the first array.
     * @param arr2 The second sorted array.
     * @param m The size of the second array.
     * @return A new array containing the intersection of arr1 and arr2.
     */
    public List<Integer> findArrayIntersection(int[] arr1, int n, int[] arr2, int m) {
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                ans.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
