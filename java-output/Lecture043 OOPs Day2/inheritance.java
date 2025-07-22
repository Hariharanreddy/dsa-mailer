import java.lang.*;

class Human {

    private int height;

    public int weight;

    private int age;

    public int getAge() {
        return this.age;
    }

    public void setWeight(int w) {
        this.weight = w;
    }

}

class Male extends Human {

    public String color;

    public void sleep() {
        System.out.println("Male Sleeping");
    }

    public int getHeight() {
        return this.height; //Note: Accessing private member of parent class
    }

}

public class Main {

    public static void main(String[] args) {

        Male m1 = new Male();
        //System.out.println(m1.height); //this will give compile time error


        /*
        Male object1 = new Male();
        System.out.println(object1.age); //this will give compile time error
        System.out.println(object1.weight);
        System.out.println(object1.height); //this will give compile time error

        System.out.println(object1.color);

        object1.setWeight(84);
        System.out.println(object1.weight);
        object1.sleep();
        */
    }
}
