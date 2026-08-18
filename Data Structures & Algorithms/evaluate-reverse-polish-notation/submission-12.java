class Solution {
    public int evalRPN(String[] tokens) {
        int b;
        int a ; 
        Stack <Integer> stack = new Stack <Integer> ();
        for(String s : tokens){
            switch (s){
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    if (b == 0) {
                        stack.push(0);
                        break;
                    }
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(s)) ;
            }
        }
        return stack.pop(); 
    }
}
