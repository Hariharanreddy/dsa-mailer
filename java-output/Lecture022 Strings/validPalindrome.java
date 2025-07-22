import java.lang.String;

class Solution {
    //Check if character is alphanumeric
    private boolean valid(char ch) {
        if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
    
    //Convert character to lowercase
    private char toLowerCase(char ch) {
        if( (ch >='a' && ch <='z') || (ch >='0' && ch <='9') )
            return ch;
        else{
            char temp = (char)(ch - 'A' + 'a');
            return temp;
        }
    }
    
    //Check if string is a palindrome
    private boolean checkPalindrome(String a) {
        int s = 0;
        int e = a.length()-1;

        while(s<=e) {
            if(a.charAt(s) != a.charAt(e)) {
                return false;       
            } else {
                s++;
                e--;
            }
        }
        return true;
    }
    
    //Main function to check if given string is a palindrome
    public boolean isPalindrome(String s) {
        //Remove non-alphanumeric characters
        String temp = "";
        for(int j=0; j<s.length(); j++) {   
            if(valid(s.charAt(j))) {
                temp += s.charAt(j);
            }
        }
        
        //Convert to lowercase
        for(int j=0; j<temp.length(); j++) { 
            temp = temp.substring(0, j) + toLowerCase(temp.charAt(j)) + temp.substring(j + 1);
        }
        
        //Check palindrome
        return checkPalindrome(temp);
    }
}
