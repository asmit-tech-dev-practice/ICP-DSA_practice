import java.util.*;
public class Stacks {  
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();

        
        for (String token : A) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperation(a, b, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        Stacks obj = new Stacks(); 

        String[] tokens = {"2", "1", "+", "3", "*"}; 
        int result = obj.evalRPN(tokens);
        System.out.println("Result: " + result);  
    }
}
