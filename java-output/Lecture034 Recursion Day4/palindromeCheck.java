import java.lang.String;

class PalindromeChecker {

    // Recursive function to check if a string is a palindrome
    static boolean checkPalindrome(String str, int i, int j) {
        // Base case: If i > j, the substring is empty or has one element, which is a palindrome
        if (i > j) {
            return true;
        }

        // If characters at i and j don't match, it's not a palindrome
        if (str.charAt(i) != str.charAt(j)) {
            return false;
        } else {
            // Recursive call to check the inner substring
            return checkPalindrome(str, i + 1, j - 1);
        }
    }

    public static void main(String[] args) {
        String name = "BookkooB";
        System.out.println(); //Added a new line

        boolean isPalindrome = checkPalindrome(name, 0, name.length() - 1);

        if (isPalindrome) {
            System.out.println("Its a Palindrome");
        } else {
            System.out.println("Its not a Palindrome");
        }
    }
}
