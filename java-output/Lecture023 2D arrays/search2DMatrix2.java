import java.util.List;
import java.util.ArrayList;

class Solution {
    /**
     * Searches a sorted matrix for a target value.
     *
     * @param matrix The sorted matrix to search.
     * @param target The target value to search for.
     * @return True if the target value is found, false otherwise.
     */
    public boolean searchMatrix(List<List<Integer>> matrix, int target) {
        int row = matrix.size();
        int col = matrix.get(0).size();

        int rowIndex = 0;
        int colIndex = col - 1;

        while (rowIndex < row && colIndex >= 0) {
            int element = matrix.get(rowIndex).get(colIndex);

            if (element == target) {
                return true;
            }

            if (element < target) {
                rowIndex++;
            } else {
                colIndex--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(1, 4, 7, 11, 15));
        matrix.add(List.of(2, 5, 8, 12, 19));
        matrix.add(List.of(3, 6, 9, 16, 22));
        matrix.add(List.of(10, 13, 14, 17, 24));
        matrix.add(List.of(18, 21, 23, 26, 30));

        int target = 5;
        boolean result = sol.searchMatrix(matrix, target);
        System.out.println("Target found: " + result); //Should print true

        target = 20;
        result = sol.searchMatrix(matrix, target);
        System.out.println("Target found: " + result); //Should print false


    }
}
