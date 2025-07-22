public class Animal {

    public int age;
    public int weight;

    public void speak() {
        System.out.println("Speaking");
    }
}

class Dog extends Animal {

}

class GermanShepherd extends Dog {

}

public class Main {
    public static void main(String[] args) {
        GermanShepherd g = new GermanShepherd();
        g.speak();
    }
}
