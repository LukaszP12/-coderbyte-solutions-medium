
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestRowColumn {

    public static String LargestRowColumn(String[] strArr) {

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            String row = strArr[i];
            matrix.add(new ArrayList<>());
            for (int j = 0; j < row.length(); j++) {
                Integer number = Integer.parseInt(row.charAt(j) + "");
                matrix.get(i).add(number);
            }
        }

        int max = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                max = Math.max(max, walk(matrix, i, j, 1, 0));
            }
        }

        return String.valueOf(max);
    }

    public static int walk(List<List<Integer>> matrix, int i, int j, int count, int sum) {
        if (i < 0 || i == matrix.size() || j < 0 || j == matrix.get(0).size()) {
            return 0;
        }

        int cellValue = matrix.get(i).get(j);

        if (count == 3) {

            if (evaluateSum(matrix, sum + cellValue)) {
                return sum + cellValue;
            }
        } else {
            return 0;
        }

        matrix.get(i).set(j, -1);

        int left = walk(matrix, i, j - 1, count + 1, sum + cellValue);
        int top = walk(matrix, i - 1, j, count + 1, sum + cellValue);
        int right = walk(matrix, i, j + 1, count + 1, sum + cellValue);
        int down = walk(matrix, i + 1, j, count + 1, sum + cellValue);

        matrix.get(i).set(j, cellValue);

        return Collections.max(Arrays.asList(left, top, right, down));
    }

    public static boolean evaluateSum(List<List<Integer>> matrix, int number) {
        int row = number / 10;
        int col = number % 10;
        return !(row >= matrix.size() || col >= matrix.get(0).size());
    }

    public static void main(String[] args) {
        String[] strings = {"234", "999", "999"};
        System.out.println(LargestRowColumn(strings));

//        String[] strings1 = {"11111", "22222"};
//        System.out.println(LargestRowColumn(strings1));
    }

}
