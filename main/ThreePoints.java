import java.util.Arrays;

public class ThreePoints {

    public static String ThreePoints(String[] strArr) {
        int[] A = Arrays.stream(strArr[0].replaceAll("[\\(\\)]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(strArr[1].replaceAll("[\\(\\)]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int[] M = Arrays.stream(strArr[2].replaceAll("[\\(\\)]", "").split(",")).mapToInt(Integer::parseInt).toArray();

        int position = (B[0] - A[0]) * (M[1] - A[1]) - (B[1] - A[1]) * (M[0] - A[0]);
        return position == 0 ? "neither" : position > 0 ? "left" : "right";
    }

    public static String ThreePoints2(String[] inputPoints) {
        int[] xPositions = new int[3];
        int[] yPositions = new int[3];
        int index = 0;

        for (String pointCoordinates : inputPoints) {
            String[] coordinates = pointCoordinates.replaceAll("[^0-9,-]", "").split(",");
            xPositions[index] = Integer.parseInt(coordinates[0]);
            yPositions[index++] = Integer.parseInt(coordinates[1]);
        }

        int[] line1 = {xPositions[1] - xPositions[0], yPositions[1] - yPositions[0]};
        int[] line2 = {xPositions[2] - xPositions[0], yPositions[2] - yPositions[0]};
        int determinant = (line1[0] * line2[1]) - (line1[1] * line2[0]);

        return ((determinant > 0) ? "left" : determinant < 0 ? "right" : "neither");
    }

    public static String ThreePoints3(String[] inputPoints) {
        String temp = inputPoints[0];
        temp = temp.replaceAll("[(|)]", "");
        String[] AxAy = temp.split(",");
        int Ax = Integer.parseInt(AxAy[0]);
        int Ay = Integer.parseInt(AxAy[1]);

        temp = inputPoints[1];
        temp = temp.replaceAll("[(|)]", "");
        AxAy = temp.split(",");
        int Bx = Integer.parseInt(AxAy[0]);
        int By = Integer.parseInt(AxAy[1]);

        temp = inputPoints[2];
        temp = temp.replaceAll("[(|)]", "");
        AxAy = temp.split(",");
        int Cx = Integer.parseInt(AxAy[0]);
        int Cy = Integer.parseInt(AxAy[1]);
        int result = (Bx - Ax) * (Cy - Ay) - (By - Ay) * (Cx - Ax);
        if (result == 0) {
            return "neither";
        } else if (result > 0) {
            return "left";
        } else {
            return "right";
        }

    }

    public static void main(String[] args) {
        String[] strings = {"(0,-3)", "(-2,0)", "(0,0)"};

        String[] strings1 = {"(0,0)", "(0,5)", "(0,2)"};
    }
}
