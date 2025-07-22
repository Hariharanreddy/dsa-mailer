import java.lang.*;

class Animal {

    public int age;
    public int weight;


    public void bark() {
        System.out.println("Barking ");
    }
}

class Human {
    public String color;

    public void speak() {
        System.out.println("Speaking ");
    }
}

//Multiple Inheritance
class Hybrid extends Animal implements Human {

}


public class Main {

    public static void main(String[] args) {

        Hybrid obj1 = new Hybrid();
        obj1.speak();
        obj1.bark();


    }
}
