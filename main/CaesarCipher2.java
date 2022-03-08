public class CaesarCipher2 {

    public static String CaesarCipher2(String msg, int shift) {

        String s = "";
        int len = msg.length();
        for (int x = 0; x < len; x++) {
            if (Character.isDigit(msg.charAt(x)) || Character.isLetter(msg.charAt(x))) {
                char c = (char) (msg.charAt(x) + 2);
                if (c > 90 && c < 97 || c > 122) {
                    s += (char) (msg.charAt(x) + (26 - shift));
                } else {
                    s += (char) (msg.charAt(x) + shift);
                }

            } else {
                s += (char) (msg.charAt(x));
            }
        }

        return s;
    }

    public static void main(String[] args) {
        String result = CaesarCipher2("adsZ", 2);
        System.out.println(result);
    }
}
