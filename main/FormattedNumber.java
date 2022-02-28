import java.util.regex.Pattern;

public class FormattedNumber {

    public static String FormattedNumber(String[] strArr) {
        return Pattern.compile("^[0-9]{1,3}(,[0-9]{3})*(\\.[0-9]+)?$").matcher(strArr[0]).matches() ? "true" : "false";
    }

    public static void main(String[] args) {
        String[] strings = {"0.232567"};
        FormattedNumber(strings);

        String[] strings1 = {"2,567.00.2"};
        FormattedNumber(strings1);
    }
}
