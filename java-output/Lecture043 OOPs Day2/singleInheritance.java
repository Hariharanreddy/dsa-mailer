public class Animal {

    public int age;
    public int weight;


    public void speak() {
        System.out.println("Speaking");
    }
}

class Dog extends Animal {

}


public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.speak();
        System.out.println(d.age);


    }
}
