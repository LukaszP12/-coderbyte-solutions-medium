
public class CaesarCipher_M {

    static String alphabet_lower_case = "abcdefghijklmnopqrstuvwxyz";
    static String alphabet_upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String CaesarCipher(String str, int num) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                int index = alphabet_lower_case.indexOf(str.charAt(i));
                char c = alphabet_lower_case.charAt(index + num);
                result += c;
            }
            if (Character.isUpperCase(str.charAt(i))) {
                int index = alphabet_upper_case.indexOf(str.charAt(i));
                char c = alphabet_upper_case.charAt(index + num);
                result += c;
            }

            if (str.charAt(i) == ' ') {
                result += " ";
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(CaesarCipher("Hello", 4));
        System.out.println(CaesarCipher("abc", 0));
    }
}
