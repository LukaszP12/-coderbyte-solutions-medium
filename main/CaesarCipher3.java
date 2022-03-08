public class CaesarCipher3 {

    public static String CaesarCipher3(String str, int num) {
        int[] codes = new int[str.length()];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int temp = Character.codePointAt(str, i);
            if ((temp >= 65 && temp <= 90) || (temp >= 97 && temp <= 122)) {
                if (temp < 97) {
                    if (num + temp <= 90) {
                        codes[i] = num + temp;
                    } else {
                        codes[i] = 65 - (90 - temp) + num - (90 - temp);
                    }
                } else {
                    if (num + temp <= 122) {
                        codes[i] = num + temp;
                    } else {
                        codes[i] = 97 - (122 - temp) + num - 1;
                    }
                }
            } else {
                codes[i] = temp;
            }
        }
        for (int letter : codes) {
            answer.append(Character.toChars(letter));
        }

        return answer.toString();
    }


}
