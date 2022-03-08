public class BinarySearchTreeLCA {
//        the second and third elements will be two different values,
//        and your goal is to find the lowest common ancestor of these two values.

    public static String BinarySearchTreeLCA(String[] strArr) {
        String[] tree = strArr[0].substring(1, strArr[0].length() - 1).split(", ");
        int a = Integer.valueOf(strArr[1]);
        int b = Integer.valueOf(strArr[1]);
        int left = Math.min(a, b);
        int right = Math.max(a, b);
        for (String node : tree) {
            int temp = Integer.valueOf(node);
            if (left <= temp && right >= temp) return node;
        }
        return "";
    }

    public static void main(String[] args) {
        String[] strings = {"[10, 5, 1, 7, 40, 50]", "5", "10"};
        String s = BinarySearchTreeLCA(strings);
        System.out.println(s);

        String[] strings1 = {"[3, 2, 1, 12, 4, 5, 13]", "5", "13"};
    }
}
