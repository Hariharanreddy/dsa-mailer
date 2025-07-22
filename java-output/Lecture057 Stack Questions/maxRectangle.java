import java.util.*;
import java.lang.*;

class Solution{
    private int[] nextSmallerElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];

        for(int i=n-1; i>=0 ; i--) {
            int curr = arr[i];
            while(s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    private int[] prevSmallerElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int curr = arr[i];
            while(s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    private int largestRectangleArea(int[] heights, int n) {
        int[] next = nextSmallerElement(heights, n);
        int[] prev = prevSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int l = heights[i];
            if(next[i] == -1) {
                next[i] = n;
            }
            int b = next[i] - prev[i] - 1;
            int newArea = l*b;
            area = Math.max(area, newArea);
        }
        return area;
    }

    public int maxArea(int[][] M, int n, int m) {
        int area = largestRectangleArea(M[0], m);

        for(int i = 1; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(M[i][j] != 0)
                    M[i][j] = M[i][j] + M[i-1][j];
                else
                    M[i][j] = 0;
            }
            area = Math.max(area, largestRectangleArea(M[i],m));
        }
        return area;
    }
}
