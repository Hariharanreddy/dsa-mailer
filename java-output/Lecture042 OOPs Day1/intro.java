```java
class Hero {

    // properties
    private int health;

    public String name;
    public char level;
    private static int timeToComplete = 5;

    // Simple constructor
    public Hero() {
        System.out.println("Simple constructor called");
        name = new String(""); // Initialize name as an empty string
    }

    // Parameterized constructor
    public Hero(int health) {
        this.health = health;
    }

    public Hero(int health, char level) {
        this.level = level;
        this.health = health;
    }

    // Copy constructor
    public Hero(Hero temp) {
        this.name = new String(temp.name); //Proper string copy
        System.out.println("Copy constructor called");
        this.health = temp.health;
        this.level = temp.level;
    }

    public void print() {
        System.out.println();
        System.out.print("[ Name: " + this.name + " ,");
        System.out.print("health: " + this.health + " ,");
        System.out.print("level: " + this.level + " ]");
        System.out.println();
    }

    public int getHealth() {
        return health;
    }

    public char getLevel() {
        return level;
    }

    public void setHealth(int h) {
        health = h;
    }

    public void setLevel(char ch) {
        level = ch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int random() {
        return timeToComplete;
    }

    // Destructor (in Java, garbage collection handles memory)
    // @Override
    // protected void finalize() throws Throwable {
    //     System.out.println("Destructor bhai called");
    //     super.finalize();
    // }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(Hero.random());

        //Example usage (uncomment to test other functionalities)
        // Hero hero1 = new Hero();
        // hero1.setHealth(12);
        // hero1.setLevel('D');
        // hero1.setName("Babbar");
        // Hero hero2 = new Hero(hero1);
        // hero1.setName("G" + hero1.name.substring(1));
        // hero1.print();
        // hero2.print();

    }
}
```
