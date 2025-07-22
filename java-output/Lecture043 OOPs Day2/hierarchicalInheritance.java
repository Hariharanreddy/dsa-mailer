public class A {

    public void func1() {
        System.out.println("Inside Funcion 1");
    }

}

class B extends A {
    public void func2() {
        System.out.println("Inside Funcion 2");
    }
}

class C extends A {
    public void func3() {
        System.out.println("Inside Funcion 3");
    }
}

public class Main {
    public static void main(String[] args) {

        A object1 = new A();
        object1.func1();

        B object2 = new B();
        object2.func1();
        object2.func2();

        C object3 = new C();
        object3.func1();
        object3.func3();
    }
}
