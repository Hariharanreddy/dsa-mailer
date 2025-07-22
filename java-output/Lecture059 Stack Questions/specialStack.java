import java.util.Stack;

class SpecialStack {
    // Define the data members.
    Stack<Integer> s;
    int mini;

    /*----------------- Public Functions of SpecialStack -----------------*/
    public SpecialStack() {
        s = new Stack<>();
        mini = Integer.MAX_VALUE;
    }

    public void push(int data) {
        //for first element
        if (s.isEmpty()) {
            s.push(data);
            mini = data;
        } else {
            if (data < mini) {
                s.push(2 * data - mini);
                mini = data;
            } else {
                s.push(data);
            }
        }
    }

    public int pop() {
        if (s.isEmpty()) {
            return -1;
        }

        int curr = s.peek();
        s.pop();
        if (curr >= mini) {
            return curr;
        } else {
            int prevMin = mini;
            int val = 2 * mini - curr;
            mini = val;
            return prevMin;
        }
    }

    public int top() {
        if (s.isEmpty())
            return -1;

        int curr = s.peek();
        if (curr < mini) {
            return mini;
        } else {
            return curr;
        }
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public int getMin() {
        if (s.isEmpty())
            return -1;

        return mini;
    }
}
