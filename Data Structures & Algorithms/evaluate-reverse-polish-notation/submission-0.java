class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (List.of("+","-","*","/").contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                int num = 0;
                switch(token) {
                    case "+":
                        num = num1+num2;
                        break;
                    case "-":
                        num = num1-num2;
                        break;
                    case "*":
                        num = num1*num2;
                        break;
                    case "/":
                        num = num1/num2;
                        break;
                }
                stack.push(num);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.peek();
    }
}
