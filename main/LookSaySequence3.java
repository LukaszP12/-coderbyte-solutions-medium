public class LookSaySequence3 {

    public static int LookSaySequence(int n) {
        String number = String.valueOf(n);
        int firstCharPosition = 0;
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(firstCharPosition) != number.charAt(i)) {
                final String digitsFound = number.substring(firstCharPosition, i);
                stringBuilder.append(digitsFound.length()).append(number.charAt(firstCharPosition));

                firstCharPosition = i;
            }
        }

        stringBuilder.append(number.substring(firstCharPosition, number.length()).length()).append(number.charAt(firstCharPosition));

        return Integer.valueOf(stringBuilder.toString());
    }

    public static void main(String[] args) {
        System.out.println(LookSaySequence(1211));
        System.out.println(LookSaySequence(2466));
    }
}
