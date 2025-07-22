import java.util.Stack;
import java.util.Vector;

class Solution {
    private Vector<Integer> nextSmallerElement(Vector<Integer> arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        Vector<Integer> ans = new Vector<>(n);

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr.get(i);
            while (s.peek() != -1 && arr.get(s.peek()) >= curr) {
                s.pop();
            }
            //ans is stack ka top
            ans.set(i, s.peek());
            s.push(i);
        }
        return ans;
    }

    private Vector<Integer> prevSmallerElement(Vector<Integer> arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        Vector<Integer> ans = new Vector<>(n);

        for (int i = 0; i < n; i++) {
            int curr = arr.get(i);
            while (s.peek() != -1 && arr.get(s.peek()) >= curr) {
                s.pop();
            }
            //ans is stack ka top
            ans.set(i, s.peek());
            s.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(Vector<Integer> heights) {
        int n = heights.size();

        Vector<Integer> next = new Vector<>(n);
        next = nextSmallerElement(heights, n);

        Vector<Integer> prev = new Vector<>(n);
        prev = prevSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int l = heights.get(i);

            if (next.get(i) == -1) {
                next.set(i, n);
            }
            int b = next.get(i) - prev.get(i) - 1;
            int newArea = l * b;
            area = Math.max(area, newArea);
        }
        return area;
    }
}
