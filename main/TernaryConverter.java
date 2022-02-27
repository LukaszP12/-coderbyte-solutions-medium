public class TernaryConverter {

    public static String TernaryConverter(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num % 3);
        String result = figureThisOut(sb, num / 3);
        return result;
    }

    private static String figureThisOut(StringBuilder sb, int rem) {
        int val = rem;
        System.out.println("The rem is: " + rem);
        while (val > 0) {
            System.out.println("val: " + val);
            System.out.println("val % 3 = " + val % 3);
            sb.insert(0, val % 3);
            val = val / 3;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(TernaryConverter(21));
        System.out.println(TernaryConverter(67));
    }
}
