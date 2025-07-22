public class UniqueNumberFinder {

    /**
     * Finds the unique number in an array using XOR operation.
     * Assumes that all numbers except one appear twice.
     *
     * @param arr The input array of integers.
     * @param size The size of the input array.
     * @return The unique number in the array.
     */
    public int findUnique(int[] arr, int size) {
        int ans = 0;

        for (int i = 0; i < size; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueNumberFinder finder = new UniqueNumberFinder();
        int[] arr = {1, 2, 3, 4, 2, 1, 3};
        int uniqueNumber = finder.findUnique(arr, arr.length);
        System.out.println("Unique number: " + uniqueNumber); // Output: Unique number: 4

    }
}
