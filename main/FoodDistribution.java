public class FoodDistribution {

    public static int FoodDistribution(int[] arr) {
        int[] min = {Integer.MAX_VALUE};
        distribute(arr, arr[0], 1, min);

        return min[0];
    }

    public static void distribute(int[] arr, int sandwitches, int pos, int[] min) {
        if (pos == arr.length || sandwitches == 0) {
            int diff = diff(arr);
            if (diff < min[0]) min[0] = diff;

            return;
        }

        int currentSwitches = arr[pos];
        for (int i = 0; i <= Math.min(currentSwitches, sandwitches); i++) {
            System.out.println("currentSwitches: " + currentSwitches);
            System.out.println("sandwitches: " + sandwitches);
            System.out.println("Math.min: " + Math.min(currentSwitches, sandwitches));
            arr[pos] -= i;
            distribute(arr, sandwitches - i, pos + 1, min);
            arr[pos] = currentSwitches;
        }
    }

    public static int diff(int[] arr) {
        int diff = 0;
        for (int i = 2; i < arr.length; i++) {
            diff += Math.abs(arr[i] - arr[i - 1]);
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] ints = {5, 2, 3, 4, 5};
        System.out.println(FoodDistribution(ints));

        int[] ints1 = {3, 2, 1, 0, 4, 1, 0};
        System.out.println(FoodDistribution(ints1));
    }
}
