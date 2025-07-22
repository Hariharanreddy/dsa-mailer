import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Given a matrix of integers, print the matrix in wave form.
     * @param arr The input matrix.
     * @param nRows The number of rows in the matrix.
     * @param mCols The number of columns in the matrix.
     * @return A list of integers representing the wave form of the matrix.
     */
    public List<Integer> wavePrint(List<List<Integer>> arr, int nRows, int mCols) {
        List<Integer> ans = new ArrayList<>();

        for (int col = 0; col < mCols; col++) {
            if ((col & 1) == 1) {
                // Odd index -> Bottom to top
                for (int row = nRows - 1; row >= 0; row--) {
                    ans.add(arr.get(row).get(col));
                }
            } else {
                // Even index -> Top to bottom
                for (int row = 0; row < nRows; row++) {
                    ans.add(arr.get(row).get(col));
                }
            }
        }
        return ans;
    }
}
