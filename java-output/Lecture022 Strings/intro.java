```java
import java.util.*;

class Solution {
    // Converts a character to lowercase.
    char toLowerCase(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return ch;
        else {
            char temp = (char) (ch - 'A' + 'a');
            return temp;
        }
    }

    // Checks if a given string is a palindrome.
    boolean checkPalindrome(char a[], int n) {
        int s = 0;
        int e = n - 1;

        while (s <= e) {
            if (toLowerCase(a[s]) != toLowerCase(a[e])) {
                return false;
            } else {
                s++;
                e--;
            }
        }
        return true;
    }

    // Reverses a given string in-place.
    void reverse(char name[], int n) {
        int s = 0;
        int e = n - 1;

        while (s < e) {
            char temp = name[s];
            name[s] = name[e];
            name[e] = temp;
            s++;
            e--;
        }
    }

    // Calculates the length of a given string.
    int getLength(char name[]) {
        int count = 0;
        for (int i = 0; name[i] != '\0'; i++) {
            count++;
        }

        return count;
    }

    // Finds the character with the maximum occurrence in a given string.
    char getMaxOccCharacter(String s) {
        int arr[] = new int[26]; // Array to store character counts

        // Count character occurrences
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int number = 0;
            if (ch >= 'a' && ch <= 'z')
                number = ch - 'a';
            else if (ch >= 'A' && ch <= 'Z')
                number = ch - 'A';
            arr[number]++;
        }

        // Find the character with the maximum occurrence
        int maxi = -1, ans = 0;
        for (int i = 0; i < 26; i++) {
            if (maxi < arr[i]) {
                ans = i;
                maxi = arr[i];
            }
        }

        return (char) ('a' + ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.getMaxOccCharacter(s));
        sc.close();
    }
}
```
