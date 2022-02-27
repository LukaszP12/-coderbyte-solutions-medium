package JavaRegex;

public class BinaryReversal2 {

    private static String BinaryReversal(String str) {
        String s = Integer.toBinaryString(Integer.parseInt(str));
        StringBuilder result = new StringBuilder(s);
        int N = s.length();
        for (int i = N - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        if (N % 8 > 0) {
            for (int i = 0; i < (8 - N % 8); i++) {
                result.append("0");
            }
        }
        str = Integer.toString(Integer.parseInt(result.toString(), 2));
        return str;
    }

    public static void main(String[] args) {
//        Assert.assertEquals(171, BinaryReversal("213"));

        int i = Integer.parseInt("1234567890", 2);
        System.out.println(i);
    }

}
