import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLElements {

//    The elements that will be used are: b, i, em, div, p

    public static String HTMLElements(String str) {
        Deque<String> stack = new ArrayDeque<String>();

        int i = 0;
        String tagName;
        while (i < str.length()) {
            if (str.charAt(i) == '<') {
                i++;
                StringBuilder builder = new StringBuilder();
                while (str.charAt(i) != '>') {
                    builder.append(str.charAt(i));
                    i++;
                }
                tagName = builder.toString();
                if (tagName.charAt(0) == '/') {
                    String endTag = tagName.substring(1, tagName.length());
                    if (endTag.equals(stack.peek())) {
                        stack.poll();
                    } else {
                        return stack.poll();
                    }
                } else {
                    stack.push(tagName);
                }
            }
            i++;
        }

        if (stack.size() > 0) {
            return stack.poll();
        }
        return "true";
    }

    public static String HTMLElements2(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean buildingString = false;
        boolean isHead = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<' && str.charAt(i + 1) != '/') {
                buildingString = true;
                isHead = true;
            } else if (str.charAt(i) == '<' && str.charAt(i + 1) == '/') {
                buildingString = true;
                isHead = false;
            } else if (str.charAt(i) == '>') {
                buildingString = false;
                if (isHead) {
                    stack.push(sb.toString());
                } else {
                    String lastString = stack.pop();
                    if (!lastString.equals(sb.toString())) {
                        return lastString;
                    }
                }
                sb = new StringBuilder();
            } else {
                if (str.charAt(i) != '/' && buildingString) {
                    sb.append(str.charAt(i));
                }
            }
        }

        return stack.isEmpty() ? "true" : stack.pop();
    }

    public static String HTMLElements3(String str) {
        ArrayList<String> stack = new ArrayList<>();
        String res = "";

        Pattern pattern = Pattern.compile("(<[A-Za-z0-9\\/]*>)");
        Matcher m = pattern.matcher(str);
        while (m.find()) {
            if (stack.size() == 0) {
                stack.add(m.group(1));
            } else {
                if (compareE(stack.get(stack.size() - 1), m.group(0))) {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(m.group(1));
                }
            }

            if (stack.size() == 0) return "true";

            for (int i = 0; i < (stack.size() / 2 + 1); i++) {
                if (!compareE(stack.get(i), stack.get(stack.size() - 1 - i))) {
                    if (checkFormatting(stack.get(stack.size() - 1 - i), false)) {
                        res = stack.get(i).replaceAll("<", "").replaceAll(">", "").trim();
                    } else {
                        stack.get(stack.size() - 1 - i).replaceAll("<", "").replaceAll("/", "").replaceAll(">", "").trim();
                        break;
                    }
                }
            }

        }

        return res;
    }

    private static boolean checkFormatting(String str, boolean bStart) {
        if (bStart) {
            if (str.charAt(0) == '<' && str.charAt(1) != '/' && str.charAt(str.length() - 1) == '>') {
                return true;
            } else {
                if (str.charAt(0) == '<' && str.charAt(1) == '/' && str.charAt(str.length() - 1) == '>') {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean compareE(String strStart, String strEnd) {
        strStart = strStart.replaceAll("<", "").replaceAll(">", "").trim();
        strEnd = strStart.replaceAll("<", "").replaceAll(">", "").trim();

        if (strStart.equals(strEnd)) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(HTMLElements2("<div><div><b></b></div></p>"));
        System.out.println(HTMLElements2("<div>abc</div><p><em><i>test test test</b></em></p>"));
    }
}
