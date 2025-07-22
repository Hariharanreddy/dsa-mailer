import java.util.*;
// { Driver Code Starts
class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                q.add(a);
            }
            Queue<Integer> ans = modifyQueue(q, k);
            while (!ans.isEmpty()) {
                int a = ans.peek();
                ans.remove();
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends
// User function Template for Java
class Solution {
    // Function to reverse first k elements of a queue.
    static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        //algo:
        //first k element stack me daaldo  and queue se hatado
        // k element stack se nikalke wapas queue me daalde 
        // fer queue k (n-k) starting k elements, wapas queue me daalde

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) {
            int val = q.peek();
            q.remove();
            s.push(val);
        }

        while (!s.isEmpty()) {
            int val = s.peek();
            s.pop();
            q.add(val);
        }

        int t = q.size() - k;

        while (t-- > 0) {
            int val = q.peek();
            q.remove();
            q.add(val);
        }

        return q;
    }
}
