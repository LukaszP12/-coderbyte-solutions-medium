import java.util.Stack;

public class MultipleBrackets {

    public static String MultipleBrackets(String str) {
        int pairs = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (stack.isEmpty() && (str.charAt(i) == ')' || str.charAt(i) == ']')) {
                return "0";
            }

            if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            }

            if (!stack.isEmpty() && (str.charAt(i) == ')')) {

                if (stack.peek() == '(') {
                    pairs++;
                } else {
                    return "0";
                }

                stack.pop();
            }

            if (!stack.isEmpty() && (str.charAt(i) == ']')) {

                if (stack.peek() == '[') {
                    pairs++;
                } else {
                    return "0";
                }

                stack.pop();
            }

        }
        if (!stack.isEmpty()) {
            return "0";
        }

        return "1 " + pairs;
    }

    public static void main(String[] args) {
        String s = "(coder)[byte)]";
        System.out.println(MultipleBrackets(s));

        String s1 = "(c([od]er)) b(yt[e])";
        System.out.println(MultipleBrackets(s1));

        //incorrect case
        String s2 = "()code[rb]yte() yes()[ss][[";
        System.out.println(MultipleBrackets(s2));
    }
}
