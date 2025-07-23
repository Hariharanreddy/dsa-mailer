1. **What the code solves:**

This code addresses the classic **"First Non-Repeating Character in a Stream"** problem. Specifically, it processes a stream (string) of characters one by one and, at each point, outputs the first character that has appeared exactly once so far in the stream. If no such character exists at a given moment, it outputs `'#'`.

---

2. **Problem Description:**

**First Non-Repeating Character in a Stream**

Given a stream of characters arriving one by one, you need to find the first non-repeating character at each point in the stream. After reading each new character, determine which character in the stream so far appears exactly once and is the earliest to appear. If no such character exists, return `'#'`.

*This problem frequently appears in coding interviews and competitive programming to test understanding of hash maps, queues, and efficient streaming data processing.*

*Real-world relevance:* This is similar to real-time analytics where you want to detect unique events or signals on-the-fly.

---

3. **Examples:**

Example 1:

Input: `"aabc"`

Step-wise output:

- After reading 'a' → first non-repeating character: `a`
- After reading 'a' again → `#` (both a's repeated)
- After reading 'b' → `b` (b is unique now)
- After reading 'c' → `b` (b is still unique and first non-repeating)

Output: `"a#bb"`

Example 2 (Edge case: all characters repeating):

Input: `"zzz"`

Step-wise output:

- 'z' → `z`
- 'z' → `#`
- 'z' → `#`

Output: `"z##"`

---

4. **Logic Explanation:**

- Use a **queue** to keep track of characters in the order they appear.
- Use a **map (hash map)** to store the frequency/count of each character.
- For each character read in the stream:
  - Add it to the queue.
  - Increment its count in the map.
  - While the queue is not empty and the character at the front has a count greater than 1 (meaning it's repeating), pop it out.
  - If after this process the queue is empty, append `'#'` to the answer string because no unique character exists.
  - Otherwise, append the character at the front of the queue to the answer string.
  
**Key points:**

- The queue ensures we always check the earliest characters first.
- Map maintains counts for O(1) lookup.
- The algorithm runs in **O(n)** time where n = length of the string, since each character is pushed and popped at most once.
- Space complexity is O(1) or O(k) where k is character set size (e.g., 26 for lowercase letters), because counts and queue hold characters from the set.

---

5. **Java Code Implementation:**

```java
import java.util.*;

// Class to solve the first non-repeating character in a stream problem
public class FirstNonRepeatingCharacter {
    
    // Method to return a string containing first non-repeating characters at each step
    public String firstNonRepeating(String stream) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < stream.length(); i++) {
            char ch = stream.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            queue.offer(ch); // add current character to the queue
            
            // Remove characters from the front of the queue if they repeat
            while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
                queue.poll();
            }
            
            if (queue.isEmpty()) {
                result.append('#'); // no unique character currently
            } else {
                result.append(queue.peek()); // first non-repeating character
            }
        }
        
        return result.toString();
    }
    
    // Main method to run the solution with input from standard input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // consume newline after int input
        
        FirstNonRepeatingCharacter solver = new FirstNonRepeatingCharacter();
        while (testCases-- > 0) {
            String inputStream = scanner.nextLine();
            String answer = solver.firstNonRepeating(inputStream);
            System.out.println(answer);
        }
        scanner.close();
    }
}
```

---

This Java code follows standard conventions:

- Class named meaningfully (`FirstNonRepeatingCharacter`).
- Uses `HashMap` and `LinkedList` for map and queue respectively.
- `StringBuilder` to efficiently build the output string.
- Comments explaining key logic steps.
- Takes multiple test cases from input for convenience similar to the original C++ code.