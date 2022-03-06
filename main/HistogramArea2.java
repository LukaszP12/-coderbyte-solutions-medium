import java.util.Stack;

public class HistogramArea2 {

    public static int HistogramArea(int[] hist) {
        Stack<Integer> s = new Stack<>();
        int n = hist.length;
        int max_area = 0;
        int tp;
        int area_with_top;


        int i = 0;
        while (i < n) {
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                tp = s.peek();
                s.pop();


                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);


                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }


        while (s.empty() == false) {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    public static void main(String[] args) {
        int[] ints = {6, 3, 1, 4, 12, 4};
        HistogramArea(ints);
    }

}
