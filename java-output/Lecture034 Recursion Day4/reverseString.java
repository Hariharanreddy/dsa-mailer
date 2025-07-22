import java.lang.String;

public class StringReversal {

    //Method to reverse a string recursively
    public static void reverse(StringBuilder str, int i, int j ) {

        System.out.println("call recieved for " + str);

        //base case
        if(i>j)
            return ;

        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
        i++;
        j--;

        //Recursive call
        reverse(str,i,j);

    }

    public static void main(String[] args) {

        StringBuilder name = new StringBuilder("abcde");
        System.out.println();
        reverse(name, 0 , name.length()-1 );
        System.out.println();
        System.out.println(name);

    }
}
