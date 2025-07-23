1. **What the Code Solves:**

The given C++ code solves the **"Celebrity Problem"**, a classic Data Structures and Algorithms problem involving identification of a special individual in a group based on known relationships.

2. **Problem Description:**

Given a party of *n* people represented by an *n x n* matrix *M*, where *M[i][j] = 1* means person *i* knows person *j*, and *0* otherwise, find if there is a **celebrity** in the party. A celebrity is defined as someone who:

- Does **not know any other person** at the party (all values in their row are 0).
- Is **known by every other person** (all values in their column, except that person's own entry, are 1).

If such a person exists, return their index; otherwise, return -1.

This problem models real-world scenarios like social network influencer detection or simplified graph problems. It’s common in competitive programming and technical interviews due to its efficient stack-based or two-pointer solution approach.

3. **Examples:**

**Example 1 (Typical case):**

Input:  
n = 3  
M =  
[[0, 1, 0],  
 [0, 0, 0],  
 [0, 1, 0]]

Output:  
1

Explanation: Person 1 knows nobody, but persons 0 and 2 know person 1.

---

**Example 2 (No celebrity case):**

Input:  
n = 3  
M =  
[[0, 1, 0],  
 [1, 0, 0],  
 [0, 1, 0]]

Output:  
-1

Explanation: No one fits the celebrity criteria.

4. **Explanation of the Logic:**

- **Step 1:** Push all person indices (0 to n-1) onto a stack.

- **Step 2:** Repeatedly pop two persons *a* and *b* from the stack and check if *a* knows *b*.  
  - If yes, *a* can't be the celebrity — push *b* back.  
  - Otherwise, *b* can't be the celebrity — push *a* back.

- **Step 3:** After this elimination process, only one candidate remains — a *potential* celebrity.

- **Step 4:** Verify the candidate:  
  - Check their entire row in M to confirm they know no one (all zeros).  
  - Check their entire column in M to confirm everyone else knows them (all ones except the candidate’s own cell).  
  - If both checks pass, return the candidate index; otherwise, return -1.

**Patterns/Techniques:**

- Uses a *stack* for elimination, reducing comparisons from O(n^2) to O(n).
- Relies on the properties of the celebrity — asymmetrical knowledge.
- Final verification ensures correctness.

**Time Complexity:** O(n) for elimination + O(n) for verification = O(n) overall.

5. **Java Conversion:**

public class CelebrityProblem {

    // Method to check if person a knows person b
    private static boolean knows(int[][] M, int a, int b) {
        return M[a][b] == 1;
    }

    // Method to find the celebrity index or return -1 if none
    public static int findCelebrity(int[][] M, int n) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Step 1: Push all persons onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(M, a, b)) {
                // a knows b, so a cannot be celebrity
                stack.push(b);
            } else {
                // a doesn't know b, so b cannot be celebrity
                stack.push(a);
            }
        }

        // Step 3: Potential celebrity
        if (stack.isEmpty())
            return -1;
        int candidate = stack.pop();

        // Step 4: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // Candidate should not know i
                if (M[candidate][i] == 1)
                    return -1;
                // i should know candidate
                if (M[i][candidate] == 0)
                    return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] M = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    M[i][j] = Integer.parseInt(line[j]);
                }
            }
            System.out.println(findCelebrity(M, n));
        }
    }
}