class MinStack {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        main.push(val);
        //System.out.println(String.format("First %d %d %b", val, min.isEmpty() ? - 1 : min.peek(), min.isEmpty()));
        
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }
    
    public void pop() {
        if (!main.isEmpty()) {
            main.pop();
        }
        if (!min.isEmpty()) {
            min.pop();
        }
        
    }
    
    public int top() {
        return main.isEmpty() ? 0 : main.peek();
    }
    
    public int getMin() {
        return min.isEmpty() ? 0 : min.peek();
    }
}
