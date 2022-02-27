import java.util.Arrays;

public class SeatingStudents {

//    following format: [K, r1, r2, r3, ...] where K represents the number of desks in a classroom

    public static int SeatingStudents(int[] arr) {
        int k = arr[0];
        int count = 0;
        boolean[] occupied = new boolean[k]; // number of seats
        Arrays.fill(occupied, false);

        for (int i = 1; i < arr.length; i++) {
            occupied[arr[i] - 1] = true;
        }

        for (int i = 0; i < k - 1; i++) {
            if (!occupied[i]) {
                if (i % 2 == 0 && !occupied[i + 1]) count++;
                if (i + 2 < k) count += !occupied[i + 2] ? 1 : 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ints = {6, 4};
        System.out.println(SeatingStudents(ints));
        int[] ints1 = {8, 1, 8};
        System.out.println(SeatingStudents(ints1));
    }
}
