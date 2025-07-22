```java
class DSA {
    static int score = 15;

    // Method a
    static void a(int i) {
        System.out.println(score + " in a"); // Print the value of score
        score++; // Increment score
        char ch = 'a'; // Declare a character variable ch
        System.out.println(i); // Print the value of i
    }

    // Method b
    static void b(int i) {
        System.out.println(score + " in b"); // Print the value of score
        System.out.println(i); // Print the value of i
    }

    public static void main(String[] args) {
        System.out.println(score + " in main"); // Print the value of score
        int i = 5; // Declare and initialize an integer variable i
        a(i); // Call method a
        b(i); // Call method b
    }
}
```
