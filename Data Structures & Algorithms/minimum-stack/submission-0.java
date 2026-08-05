class MinStack {

    class Node {
        int value;
        int min;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> stk;

    public MinStack() {
        stk = new Stack<>();
    }

    public void push(int val) {

        if (stk.isEmpty()) {
            stk.push(new Node(val, val));
        } else {

            int currentMin = stk.peek().min;

            stk.push(new Node(val, Math.min(val, currentMin)));
        }
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek().value;
    }

    public int getMin() {
        return stk.peek().min;
    }
}