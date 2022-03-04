public class LookSaySequence2 {

    public static int LookSaySequence(int num) {

        int repeatCount = 1;
        String number = Integer.toString(num);
        String returnString = "";
        int parsedInt = 0;

        for (int i = 0; i < number.length(); i++) {
            if (i == number.length() - 1) {
                returnString += repeatCount + "" + number.charAt(i);
            } else {
                if (number.charAt(i) == number.charAt(i + 1)) {
                    repeatCount++;
                } else {
                    returnString += repeatCount + "" + number.charAt(i);
                    repeatCount = 1;
                }
            }

        }

        parsedInt = Integer.parseInt(returnString);

        return parsedInt;
    }

    public static void main(String[] args) {
        System.out.println(LookSaySequence(1211));
        System.out.println(LookSaySequence(2466));
    }
}
