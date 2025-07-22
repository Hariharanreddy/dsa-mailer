```java
class A {

    public void sayHello() {
        System.out.println("Hello Love Babbar");
    }
    
    public int sayHello(char name) {
        System.out.println("Hello Love Babbar");
        return 1;
    }

    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

}

class B {
    public int a;
    public int b;

    public int add() {
        return a + b;
    }

    public void add(B obj) { //Overloaded + operator as a method
        //int value1 = this.a;
        //int value2 = obj.a;
        //System.out.println("output " + (value2 - value1));
        System.out.println("Hello Babbar");
    }

    public void invoke() { //Replacing () operator overloading
        System.out.println("main Bracket hu " + this.a);
    }

}

class Animal {
    public void speak() {
        System.out.println("Speaking ");
    }
}

class Dog extends Animal {

    public void speak() {
        System.out.println("Barking ");
    }
}

public class Main {
    public static void main(String[] args) {

        Dog obj = new Dog();
        obj.speak();




        //B obj1 = new B();
        //B obj2 = new B();

        //obj1.a = 4;
        //obj2.a = 7;

        //obj1.add(obj2); //Calling overloaded + operator
        //obj1.invoke(); //Calling the method replacing () operator


        //A obj = new A();
        //obj.sayHello();

    }
}
```
