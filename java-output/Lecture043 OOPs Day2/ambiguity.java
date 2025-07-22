```java
class A {
    // Method to print "I am A"
    public void func() {
        System.out.println(" I am A");
    }
}

class B {
    // Method to print "I am B"
    public void func() {
        System.out.println(" I am B");
    }
}

// Class C inherits from both A and B
class C extends A implements B {

}

public class Main {
    public static void main(String[] args) {
        // Creating an object of class C
        C obj = new C();
        // Calling func() method of class A using explicit scope resolution
        obj.A.func();
        // Calling func() method of class B using explicit scope resolution. Note that we use the interface B here as C implements B
        obj.func(); //Since B's func() is not overridden in C, we can directly call it without explicit scope resolution, or even implement it in C if wanted

    }
}
```
