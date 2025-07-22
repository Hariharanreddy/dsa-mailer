```java
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        char[] ch = {'a', 'b', 'c', 'd', 'e'}; //Note: Strings are objects in Java, not arrays of characters.

        System.out.println(arr); //Prints the memory address of the array.
        //Attention here: In Java, printing a character array will print the memory address. To print its content use Arrays.toString(ch)
        System.out.println(ch); //Prints the memory address of the character array.
        System.out.println(new String(ch)); //Prints "abcde"

        char[] c = ch; //In Java, it is easier to copy array than create pointer and work with addresses
        //Prints entire string - In Java, arrays can be used in the same way as pointers are used in C++ 
        System.out.println(new String(c)); //Prints "abcde"


        char temp = 'z';
        char[] p = {temp}; //In Java, it is easier to copy array than create pointer and work with addresses.

        System.out.println(p); //Prints the memory address of the character array.
        System.out.println(new String(p)); //Prints "z"

    }
}
```
