import java.util.*;

class Solution {
    private boolean knows(int[][] M, int a, int b, int n) {
        if (M[a][b] == 1)
            return true;
        else
            return false;
    }

    public int celebrity(int[][] M, int n) {
        Stack<Integer> s = new Stack<>();
        // step1: push all element in stack
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        // step2: get 2 elements and compare them

        while (s.size() > 1) {

            int a = s.pop();

            int b = s.pop();

            if (knows(M, a, b, n)) {
                s.push(b);
            } else {
                s.push(a);
            }
        }
        int ans = s.pop();
        // step3: single element in stack is potential celeb
        // so verify it

        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (M[ans][i] == 0)
                zeroCount++;
        }

        // all zeroes
        if (zeroCount != n)
            return -1;

        // column check
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            if (M[i][ans] == 1)
                oneCount++;
        }

        if (oneCount != n - 1)
            return -1;

        return ans;

    }
}
