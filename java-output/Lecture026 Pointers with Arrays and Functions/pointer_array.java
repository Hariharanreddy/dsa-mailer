```java
class Main {
    public static void main(String[] args) {
        //int arr[10] = {23, 122, 41, 67};

        /*
        System.out.println("address of first memory block is " + arr); //This will not work in java as we cannot get memory address directly.
        System.out.println(arr[0]);
        System.out.println("address of first memory block is " + &arr[0]); // This is not valid in java.

        System.out.println("4th " + *arr); // Dereferencing is not directly possible in Java.
        System.out.println("5th " + (*arr + 1)); // Dereferencing is not directly possible in Java.
        System.out.println("6th " + *(arr + 1)); // Dereferencing is not directly possible in Java.
        System.out.println("7th " + (*arr + 1)); // Dereferencing is not directly possible in Java.
        System.out.println("8th " + arr[2]);
        System.out.println("9th " + *(arr + 2)); // Dereferencing is not directly possible in Java.

        int i = 3;
        System.out.println(i[arr]); //This is not valid in Java.


        int temp[] = {1, 2};
        System.out.println(temp.length * 4); // Sizeof operator is not available in Java.  Assuming int is 4 bytes.
        System.out.println("1st " + Integer.BYTES); // Sizeof operator is not available in Java.
        System.out.println("2nd " + Integer.BYTES); // Sizeof operator is not available in Java.

        int ptr = temp[0]; // We cannot get the address in Java.
        System.out.println(Integer.BYTES); //Sizeof operator is not available in Java.
        System.out.println(Integer.BYTES); //Sizeof operator is not available in Java.
        System.out.println(Integer.BYTES); //Sizeof operator is not available in Java.


        int a[] = {1, 2, 3, 5};
        //System.out.println("->" + &a[0]); //This is not valid in java.
        //System.out.println(&a); //This is not valid in java.
        //System.out.println(a); //This is not valid in java.

        int p = a[0]; // We cannot directly get the memory address in Java.
        //System.out.println(p); //This is not valid in java.
        //System.out.println(*p); //This is not valid in java.
        System.out.println("->" + p); //This is not valid in java.

         */

        int arr[] = new int[10];

        //ERROR  // This is not valid in java.
        //arr = arr + 1;


        int ptr = arr[0]; // We are just assigning the value.  Direct memory manipulation is not possible in java.
        System.out.println(ptr);
        ptr = ptr + 1;
        System.out.println(ptr);
    }
}
```
