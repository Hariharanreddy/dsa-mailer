import java.util.*;
import java.lang.*;

class Solution {
    //Function to find the first negative integer in every window of size k.
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        Deque<Integer> dq = new LinkedList<>();
        long[] ans = new long[N - K + 1];
        int negative = -1;

        // Process first window
        for (int i = 0; i < K; i++) {
            if (A[i] < 0) {
                dq.addLast(i);
            }
        }

        // Push ans for FIRST window
        if (dq.size() > 0) {
            ans[0] = A[dq.getFirst()];
        } else {
            ans[0] = 0;
        }

        // Now process for remaining windows
        for (int i = K; i < N; i++) {
            // First pop out of window element

            if (!dq.isEmpty() && (i - dq.getFirst()) >= K) {
                dq.removeFirst();
            }

            // Then push current element
            if (A[i] < 0) {
                dq.addLast(i);
            }

            // Put in ans
            if (dq.size() > 0) {
                ans[i - K + 1] = A[dq.getFirst()];
            } else {
                ans[i - K + 1] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            int k = sc.nextInt();
            long[] ans = printFirstNegativeInteger(arr, n, k);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
