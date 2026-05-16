package Stack;

import static Stack.InfixToPostfix.infixToPostfix;

public class InfixToPrefix {
    public String infixToPrefix(String s) {
        // code here
        StringBuilder sb = new StringBuilder();

        // Reverse the infix expression
        sb.reverse();

        // Replace '(' with ')' and vice versa
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        // Get the postfix of the modified string
        String prefix = infixToPostfix(sb.toString());

        // Reverse the postfix to get the prefix
        return new StringBuilder(prefix).reverse().toString();
    }
}
