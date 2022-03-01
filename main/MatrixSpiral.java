public class MatrixSpiral {

    public static String MatrixSpiral(String[] strArr) {
        String[] t = strArr[0].replaceAll("^[0-9]", "").split(",");
        int b = t.length;
        int[][] matrix = new int[strArr.length][b];
        for (int i = 0; i < strArr.length; i++) {
            String[] temp = strArr[i].replaceAll("[^0-9,]", "").split(",");
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Integer.valueOf(String.valueOf(temp[j]));
            }
        }

        return spiralCreator(strArr.length, b, matrix);
    }

    private static String spiralCreator(int m, int n, int a[][]) {
        String result = "";
        int i, k = 0, l = 0;
        while (k < m && l < n) {
            for (i = l; i < n; ++i) {
                System.out.println("a[k][i] " + a[k][i]);
                result += a[k][i] + ",";
            }
            k++;
            System.out.println("k++ " + k);
            System.out.println("m: " + m);
            for (i = k; i < m; ++i) {
                System.out.println("a[i][n - 1]" + a[i][n - 1]);
                result += a[i][n - 1] + ",";
            }
            n--;
            System.out.println("n-- " + n);
            if (k < m) {
                System.out.println("k < m " + k + " < " + m);
                for (i = n - 1; i >= l; i--) {
                    System.out.println("a[m - 1][i] " + a[m - 1][i]);
                    result += a[m - 1][i] + ",";
                }
                m--;
                System.out.println("m-- " + m);
            }
            if (l < n) {
                System.out.println("l < n" + l + " < " + n);
                for (i = m - 1; i >= k; --i) {
                    System.out.println("a[i][l] " + a[i][l]);
                    result += a[i][l] + ",";
                }
                System.out.println(l);
                l++;
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        String[] strings1 = {"[4, 5, 6, 5]", "[1, 1, 2, 2]", "[5, 4, 2, 9]"};
        System.out.println("The result: ");
        System.out.println(MatrixSpiral(strings1));
    }
}
