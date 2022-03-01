public class FormattedNumber2 {

    public static boolean FormattedNumber(String[] strArr) {
        String str = strArr[0];
        String[] arr = str.split("\\.");
        if (strArr.length > 2) {
            return false;
        } else if (arr.length > 1) {
            for (int i = 0; i < strArr[1].length(); i++) {
                if (!Character.isDigit(strArr[1].charAt(i))) {
                    return false;
                }
            }
        }
        String[] arr2 = strArr[0].split(",");
        if (strArr[0].length() > 3) {
            return false;
        }
        for (int i = 0; i < strArr[0].length(); i++) {
            if (!Character.isDigit(strArr[0].charAt(i))) {
                return false;
            }
        }
        for (int i = 1; i < strArr.length; i++) {
            if (arr2[i].length() != 3) {
                return false;
            }
            if (!Character.isDigit(arr2[i].charAt(0))) {
                return false;
            }
            if (!Character.isDigit(arr2[i].charAt(1))) {
                return false;
            }
            if (!Character.isDigit(arr2[i].charAt(2))) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String[] strings = {"0.232567"};

        String[] strings1 = {"2,567.00.2"};
    }
}
