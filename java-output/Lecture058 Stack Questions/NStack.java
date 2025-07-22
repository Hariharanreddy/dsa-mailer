```java
class NStack {
    private int[] arr;
    private int[] top;
    private int[] next;

    private int n, s;

    private int freespot;

    // Initialize your data structure.
    public NStack(int N, int S) {
        n = N;
        s = S;
        arr = new int[s];
        top = new int[n];
        next = new int[s];

        // top initialize
        for (int i = 0; i < n; i++) {
            top[i] = -1;
        }

        // next initialize
        for (int i = 0; i < s; i++) {
            next[i] = i + 1;
        }
        // update last index value to -1
        next[s - 1] = -1;

        // initialize freespot
        freespot = 0;

    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // check for overflow
        if (freespot == -1) {
            return false;
        }

        // find index
        int index = freespot;

        // insert element into array
        arr[index] = x;

        // update freespot
        freespot = next[index];

        // update next;
        next[index] = top[m - 1];

        // update top
        top[m - 1] = index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // check underflow condition
        if (top[m - 1] == -1) {
            return -1;
        }

        int index = top[m - 1];

        top[m - 1] = next[index];

        next[index] = freespot;

        freespot = index;

        return arr[index];
    }
}
```
