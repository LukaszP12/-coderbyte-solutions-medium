import java.util.regex.Pattern;

public class BracketMatcher_Regex {

    public static int BracketMatcher_Regex(String str) {
        int leftCount = 0;
        int rightCount = 0;
        int count = 0;
        Pattern badStart = Pattern.compile("^\\)");
        Pattern badEnd = Pattern.compile("\\($");
        String right = ("\\(");
        String left = ("\\(");

        for (int i = 0; i < str.length(); i++) {
            if (Character.toString(str.charAt(i)).matches(right)) {
                count++;
            } else if (Character.toString(str.charAt(i)).matches(left)) {
                count--;
                if (count < 0) {
                    return 0;
                }
            }
        }

        if (count != 0) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {

    }
}
