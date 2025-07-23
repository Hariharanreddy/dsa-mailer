1. **What the Code Solves:**

The given C++ code solves the **"Circular Tour"** or **"Gas Station"** problem, which involves finding a starting point in a circular route of petrol pumps from which a truck can complete the entire circuit without running out of petrol.

---

2. **Problem Description:**

*Given* a circular route with *n* petrol pumps, each pump provides a certain amount of petrol and is a certain distance away from the next pump. A truck starts at one of the petrol pumps and must travel around the circle once, collecting petrol from each pump and expending petrol to travel to the next. Your task is to determine the index of the petrol pump from which the truck can start so that it completes the entire circular tour without the petrol in its tank dropping below zero at any point.

If such a starting pump exists, return its index; otherwise, return -1.

**Context:** This problem is a classic in data structures and algorithms, frequently appearing in coding interviews and competitive programming. It tests problem-solving ability related to arrays, greedy strategies, and simulation under constraints.

---

3. **Examples:**

Example 1:  
Input:  
pumps = [(petrol=4, distance=6), (petrol=6, distance=5), (petrol=7, distance=3), (petrol=4, distance=5)]

Output:  
1

Explanation: Starting at pump index 1, the truck can complete the circle without running out of petrol.

---

Example 2:  
Input:  
pumps = [(petrol=1, distance=5), (petrol=10, distance=3), (petrol=3, distance=4)]

Output:  
1

Explanation: Only starting at index 1 (petrol=10, distance=3) allows completing the full circle.

---

Example 3 (Edge Case):  
Input:  
pumps = [(petrol=2, distance=3), (petrol=2, distance=3), (petrol=2, distance=3)]

Output:  
-1

Explanation: No starting petrol pump allows the truck to complete the tour.

---

4. **Explanation of the Logic:**

- Initialize three variables:  
  - `start` = 0 (candidate start index)  
  - `balance` = 0 (current petrol surplus)  
  - `deficit` = 0 (petrol deficit when we fail to continue)

- Traverse all pumps from 0 to n-1:  
  - At each pump, add the difference `petrol - distance` to `balance` (current petrol surplus/deficit).  
  - If `balance` becomes negative at any point:  
    - We cannot start from any pump between the current `start` and this pump, so update `start` to `i + 1`.  
    - Accumulate the negative balance into `deficit` since we have lost this petrol surplus.

- After the loop, check if `balance + deficit >= 0`:  
  - If yes, return `start` since there's enough total petrol to cover the total distance.  
  - Otherwise, return `-1`.

**Patterns / Techniques:**  
- Greedy approach: The earliest viable start point is found by skipping intervals where we run out of petrol.  
- No need to check each pump as a start separately; this approach runs in O(n).  
- Important insight: If total petrol > total distance, a solution always exists.

**Time Complexity:** O(n) — one pass through the list.

---

5. **Converted Java Code:**

```java
import java.util.Scanner;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    /**
     * Finds the starting petrol pump index to complete the circular tour without
     * running out of petrol.
     * 
     * @param pumps array of petrol pumps
     * @return starting index of the tour or -1 if no solution exists
     */
    public static int findStartingPump(PetrolPump[] pumps) {
        int start = 0;
        int balance = 0;
        int deficit = 0;

        for (int i = 0; i < pumps.length; i++) {
            balance += pumps[i].petrol - pumps[i].distance;

            // If balance is negative, cannot start from current start
            if (balance < 0) {
                // Next pump might be a valid start
                start = i + 1;
                // Accumulate deficit petrol
                deficit += balance;
                // Reset balance since starting fresh
                balance = 0;
            }
        }

        // Check if total petrol is enough for the tour
        if (balance + deficit >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    // Driver code for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();  // Number of petrol pumps
            PetrolPump[] pumps = new PetrolPump[n];
            for (int i = 0; i < n; i++) {
                int petrol = sc.nextInt();
                int distance = sc.nextInt();
                pumps[i] = new PetrolPump(petrol, distance);
            }
            int result = findStartingPump(pumps);
            System.out.println(result);
        }
        sc.close();
    }
}
```

- This Java program uses a class `PetrolPump` to store petrol and distance.  
- The main logic is inside `findStartingPump`, which implements the greedy solution.  
- The program reads multiple test cases from standard input and prints the result for each.  
- Comments clarify key steps and reasoning.