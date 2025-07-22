import java.lang.String;

class Solution {
    /**
     * Removes all occurrences of a given substring from a string.
     *
     * @param s The input string.
     * @param part The substring to remove.
     * @return The string with all occurrences of the substring removed.
     */
    public String removeOccurrences(String s, String part) {
        //While loop continues as long as the string s is not empty and the substring part is found within s
        while(s.length() != 0 && s.indexOf(part) != -1) {
            //Removes the first occurrence of part from s
            s = s.substring(0, s.indexOf(part)) + s.substring(s.indexOf(part) + part.length());
        }
        return s;
    }
}
