public class PreorderTraversal {

    public static String PreorderTraversal(String[] strArr) {
        Tree tree = new Tree(strArr);
        StringBuilder sb = new StringBuilder();
        tree.preorder(sb, tree.root);
        return sb.toString();
    }

    static class Tree {
        Node root;

        Tree(String[] nodes) {
            this.root = buildTree(nodes, new Node(nodes[0]), 0);
        }

        private Node buildTree(String[] nodes, Node n, int i) {
            if (i < nodes.length) {
                n = new Node(nodes[i]);
                n.left = buildTree(nodes, n.left, 2 * i + 1);
                n.right = buildTree(nodes, n.left, 2 * i + 2);
            }
            return n;
        }

        void preorder(StringBuilder sb, Node n) {
            if (n != null && !n.value.equals("#")) {
                sb.append(n.value).append(" ");
                preorder(sb, n.left);
                preorder(sb, n.right);
            }
        }

    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"4", "1", "5", "2", "#", "#", "#"};
        String s = PreorderTraversal(strings);
        System.out.println(s);

        String[] strings1 = {"2", "6", "#"};
        String s1 = PreorderTraversal(strings1);
        System.out.println(s1);
    }

}
