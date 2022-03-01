import java.util.Stack;

public class MultipleBrackets2 {

    public static String MultipleBrackets(String str) {
        str = str.replaceAll("[^\\(\\)\\[\\]]", "");

        Stack<Character> stack = new Stack<>();

        int numOfBracketsPairs = 0;

        for (char c : str.toCharArray()) {
            if (c == ')') {
                if (stack.empty()) return "0";
                if ((Character) stack.pop() != '(') return "0";
                numOfBracketsPairs++;
                continue;
            }
            if (c == ']') {
                if (stack.empty()) return "0";
                if ((Character) stack.pop() != '[') return "0";
                numOfBracketsPairs++;
                continue;
            }
            stack.push(c);
        }

        return (!stack.empty() ? "0" : "1" + " " + numOfBracketsPairs);
    }


    public static void main(String[] args) {
        String s = "(coder)[byte)]";
        System.out.println(MultipleBrackets(s));

        String s1 = "(c([od]er)) b(yt[e])";
        System.out.println(MultipleBrackets(s1));
    }
}