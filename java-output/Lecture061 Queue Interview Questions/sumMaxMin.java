import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {

    public int solve(int[] arr, int n, int k) {
        //Using Deque for efficient operations
        Deque<Integer> maxi = new ArrayDeque<>();
        Deque<Integer> mini = new ArrayDeque<>();

        //Processing the first k-sized window
        for (int i = 0; i < k; i++) {
            while (!maxi.isEmpty() && arr[maxi.getLast()] <= arr[i]) {
                maxi.removeLast();
            }
            while (!mini.isEmpty() && arr[mini.getLast()] >= arr[i]) {
                mini.removeLast();
            }
            maxi.addLast(i);
            mini.addLast(i);
        }
        int ans = 0;
        ans += arr[maxi.getFirst()] + arr[mini.getFirst()];

        //Processing remaining windows
        for (int i = k; i < n; i++) {
            //Removal of elements outside the current window
            while (!maxi.isEmpty() && i - maxi.getFirst() >= k) {
                maxi.removeFirst();
            }
            while (!mini.isEmpty() && i - mini.getFirst() >= k) {
                mini.removeFirst();
            }
            //Addition of the new element
            while (!maxi.isEmpty() && arr[maxi.getLast()] <= arr[i]) {
                maxi.removeLast();
            }
            while (!mini.isEmpty() && arr[mini.getLast()] >= arr[i]) {
                mini.removeLast();
            }
            maxi.addLast(i);
            mini.addLast(i);
            ans += arr[maxi.getFirst()] + arr[mini.getFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(sol.solve(arr, 7, k));
    }
}
