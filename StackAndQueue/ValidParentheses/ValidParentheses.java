package StackAndQueue.ValidParentheses;

import java.util.Stack;

public class ValidParentheses {
    boolean isValid(String x) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '(' || x.charAt(i) == '{' || x.charAt(i) == '[') {
                st.push(x.charAt(i));
            } else {
                if (st.isEmpty()) return false;

                char c = st.peek();
                if ((x.charAt(i) == ')' && c == '(') || (x.charAt(i) == '}' && c == '{') || (x.charAt(i) == ']' && c == '[')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}

//TC: O(N) where N is the length of the string
//SC: O(N) where N is the length of the string in the worst case 