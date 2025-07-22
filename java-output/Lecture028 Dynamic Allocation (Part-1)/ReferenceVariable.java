import java.lang.ref.Reference;

class DSACode {

    // Java doesn't allow returning a reference to a local variable like this C++ function does.  This will cause issues.
    //int& func(int a) {
    //    int num = a;
    //    int& ans = num;
    //    return ans;
    //}

    //This function returns a pointer to the local variable which will become invalid once the function ends, causing a dangling pointer.
    //int* fun(int n) {
    //    int* ptr = &n;
    //    return ptr;
    //}

    //Pass by reference using wrapper class
    void update2(DataWrapper n) {
        n.value++;
    }

    //Pass by value
    void update1(int n) {
        n++;
    }

    public static void main(String[] args) {
        //int i = 5;
        //int& j = i;

        int n = 5;
        DSACode obj = new DSACode();
        System.out.println("Before " + n);
        obj.update2(new DataWrapper(n)); //Pass by reference using wrapper class
        System.out.println("After " + n);

        //fun(n); // This is unsafe and will not work correctly in Java
    }

    static class DataWrapper {
        int value;
        DataWrapper(int val) {
            value = val;
        }
    }
}
