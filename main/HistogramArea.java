public class HistogramArea {

    public static int HistogramArea(int[] arr) {

        int max = 0, maxArea = 0;

        for (int i : arr) {
            if (i > max) {
                max = i;
                maxArea = max;
            }
        }

        int area = 0;
        for (int height = 1; height <= max; height++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= height) {
                    area += height;
                } else {
                    if (area > maxArea) {
                        maxArea = area;
                        area = 0;
                    }
                }
            }
            if (area > maxArea) {
                maxArea = area;
                area = 0;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] ints = {6, 3, 1, 4, 12, 4};
        int i = HistogramArea(ints);
        System.out.println(i);

        int[] ints1 = {5, 6, 7, 4, 1};
        int i1 = HistogramArea(ints1);
        System.out.println(i1);
    }
}
