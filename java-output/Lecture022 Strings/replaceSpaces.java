import java.lang.String;

class StringReplace{

    //Method to replace spaces with @40
    public String replaceSpaces(String str){
        //Creating a StringBuilder for efficient string manipulation
        StringBuilder temp = new StringBuilder();

        //Iterating through the string
        for(int i=0; i<str.length(); i++){
            //Checking if the character is a space
            if(str.charAt(i) == ' '){
                //Replacing space with @40
                temp.append("@40");
            } else {
                //Appending other characters as it is
                temp.append(str.charAt(i));
            }
        }
        //Returning the modified string
        return temp.toString();
    }

    public static void main(String[] args){
        StringReplace obj = new StringReplace();
        String str = "This is a string";
        String replacedString = obj.replaceSpaces(str);
        System.out.println(replacedString);
    }
}
