package Chap11;

import java.util.*;

public class ExpValidCheck {
    public static void main(String[] args) {
        
        if (args.length != 1) {

            System.out.println("Usage: java ExpValidCheck \"EXPRESSION\"");
            System.out.println("Example: java ExpValidCheck \"((2+3)*1)+3\"");
            System.exit(0);
        }

        Stack<String> st = new Stack<>();
        String expression = args[0];
        System.out.println("expression: " + expression);

        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (ch == '(') {
                    st.push(ch + "");
                } else if (ch == ')') {
                    st.pop();
                }
            }

            if (st.isEmpty()) {
                System.out.println("Matches brackets.");
            } else {
                System.out.println("Not matches brackets.");
            }

        } catch (EmptyStackException e) {
            System.out.println("Not matches brackets.");
        }

    }
}
