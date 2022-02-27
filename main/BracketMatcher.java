import java.util.Stack;

public class BracketMatcher {

    public static String BracketMatcher(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty()) return "0";
                else stack.pop();
            }
        }
        return "" + (stack.isEmpty() ? 1 : 0);
    }

    public static void main(String[] args) {
        String s = "(c(oder)) b(yte)";
        System.out.println(s);

        String s1 = "(coder)(byte))";
    }
}
