public class BinarySearchTreeLCA2 {

    public static int BinarySearchTreeLCA2(String[] strArr) {
        String[] nodeArray = strArr[0].substring(1, strArr[0].length() - 1).split(",");
        int[] nodes = new int[nodeArray.length];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(nodeArray[i].trim());
        }

        int n1 = Integer.parseInt(strArr[1]);
        int n2 = Integer.parseInt(strArr[2]);

        int small = n1 > n2 ? n2 : n1;
        int large = n1 > n2 ? n1 : n2;

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] >= small && nodes[i] <= large) return nodes[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] strings = {"[10, 5, 1, 7, 40, 50]", "5", "10"};
        System.out.println(BinarySearchTreeLCA2(strings));

        String[] strings1 = {"[3, 2, 1, 12, 4, 5, 13]", "5", "13"};
        System.out.println(BinarySearchTreeLCA2(strings1));
    }
}
