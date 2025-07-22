import java.util.List;
import java.util.ArrayList;

class Solution {
    /**
     * Searches a sorted matrix for a target value using binary search.
     *
     * @param matrix The sorted matrix to search.
     * @param target The target value to search for.
     * @return True if the target value is found, false otherwise.
     */
    public boolean searchMatrix(List<List<Integer>> matrix, int target) {
        int row = matrix.size();
        int col = matrix.get(0).size();

        int start = 0;
        int end = row * col - 1;

        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            int element = matrix.get(mid / col).get(mid % col);

            if (element == target) {
                return true;
            }

            if (element < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
