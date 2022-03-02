import java.util.*;
import java.io.*;

public class BoggleSolver2 {

    public static char[][] boggleMatrix = new char[4][4];
    public static ArrayList<Node> solutionNodes = new ArrayList<>();

    public static class Node {
        public Node(int i, int j, Node parent) {
            this.i = i;
            this.j = j;
            this.parent = parent;
        }

        public ArrayList<Node> nextPossibleNodes() {
            ArrayList<Node> nextPossibleNodes = new ArrayList<>();
            if (i + 1 < 4) {
                nextPossibleNodes.add(new Node(i + 1, j, this));
            }
            if (i - 1 > -1) {
                nextPossibleNodes.add(new Node(i - 1, j, this));
            }
            if (j + 1 < 4) {
                nextPossibleNodes.add(new Node(i, j + 1, this));
            }
            if (j - 1 > -1) {
                nextPossibleNodes.add(new Node(i, j - 1, this));
            }
            if (i - 1 > -1 && j - 1 > -1) {
                nextPossibleNodes.add(new Node(i - 1, j - 1, this));
            }
            if (i + 1 < 4 && j + 1 < 4) {
                nextPossibleNodes.add(new Node(i + 1, j + 1, this));
            }
            if (i + 1 < 4 && j - 1 > -1) {
                nextPossibleNodes.add(new Node(i + 1, j - 1, this));
            }
            if (i - 1 > -1 && j + 1 < 4) {
                nextPossibleNodes.add(new Node(i - 1, j + 1, this));
            }
            ArrayList<Node> filteredNodes = new ArrayList<>();

            loop1:
            for (Node UFN : nextPossibleNodes) {
                Node t = UFN.getParent();

                while (t != null) {
                    int pI = t.getI();
                    int pJ = t.getJ();
                    if (UFN.getI() == pI && UFN.getJ() == pJ) {
                        continue loop1;
                    }
                    t = t.getParent();
                }
                filteredNodes.add(UFN);

            }


            return filteredNodes;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }


        private Node parent;
        private int i;
        private int j;

    }

    public static boolean wordExist(String word) {

        char searchingChar = word.charAt(0);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (boggleMatrix[i][j] == searchingChar) {
                    if (word.length() == 1) {
                        return true;
                    }
                    Node startingNode = new Node(i, j, null);
                    ArrayList<Node> processor = startingNode.nextPossibleNodes();
                    for (int k = 1; k < word.length(); k++) {


                        char nextSeaching = word.charAt(k);
                        ArrayList<Node> dump = new ArrayList<>();

                        for (Node pNode : processor) {

                            if (boggleMatrix[pNode.getI()][pNode.getJ()] == nextSeaching) {
                                Node t = pNode;
                                StringBuilder built = new StringBuilder();
                                while (t != null) {

                                    built.append(boggleMatrix[t.getI()][t.getJ()]);
                                    t = t.getParent();
                                }
                                if (built.length() == word.length()) {
                                    solutionNodes.add(pNode);
                                    return true;
                                }
                                dump.addAll(pNode.nextPossibleNodes());

                            }

                        }
                        if (dump.isEmpty()) {
                            break;
                        }
                        processor.clear();
                        processor.addAll(dump);


                    }


                }

            }

        }


        return false;
    }

    public static String BoggleSolver(String[] strArr) {
        /*
        "aaey,
        rrum,
        tgmn,
        ball", "all,ball,mur,raeymnl,tall,true,trum"}
         */

        strArr[0] = strArr[0].replace(" ", "");
        String[] rows = strArr[0].split(",");
        for (int i = 0; i < 4; i++) {
            String row = rows[i];
            for (int j = 0; j < 4; j++) {
                boggleMatrix[i][j] = row.charAt(j);
            }
        }

        boolean exists = true;
        String badWords = "";
        String[] searchingWords = strArr[1].split(",");
        for (String word : searchingWords) {
            if (!wordExist(word)) {
                badWords += word + ",";
                exists = false;
            }
        }
        if (exists) {
            return "true";
        } else {
            return badWords.substring(0, badWords.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"aaey, rrum, tgmn, ball", "all,ball,mur,raeymnl,tall,true,trum"};
        System.out.println(BoggleSolver(strings));

        String[] strings1 = {"aaey, rrum, tgmn, ball", "all,ball,mur,raeymnl,rumk,tall,true,trum,yes"};
        System.out.println(BoggleSolver(strings1));
    }

}