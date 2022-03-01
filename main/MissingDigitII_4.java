public class MissingDigitII_4 {

    public static String MissingDigitII(String str) {
        int k = 10;
        String result = "";
        char oper = 0;
        String[] t = str.replaceAll(" ", "").split("[*+-/=]");
        int b = Integer.valueOf(t[1]);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/') {
                oper = str.charAt(i);
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int a = Integer.valueOf(t[0].replaceAll("[?]", "" + i));
                int c = Integer.valueOf(t[2].replaceAll("[?]", "" + j));
                if (helperFunction(a, b, oper) == c) {
                    result = "" + i + " " + j;
                }
            }
        }

        return result;
    }

    private static int helperFunction(int a, int b, char oper) {
        switch (oper) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    return 0;
                }

        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "56? * 106 = 5?678";
        System.out.println(MissingDigitII(s));

        String s1 = "18?1 + 9 = 189?";
        System.out.println(MissingDigitII(s1));
    }
}
