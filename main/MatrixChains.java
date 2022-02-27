public class MatrixChains {

//    array of positive integers stored in arr where every pair will represent an NxM matrix.
//if arr is [1, 2, 3, 4] this means you have a 1x2, 2x3, and a 3x4 matrix.

    // Naive solution:
    // - Place parentheses at all possible places
    // - Calculate the cost of each placement
    // - Return the minimum value

    public static int MatrixChains(int[] arr) {
        int len = arr.length;

        int[][] dp = new int[len][len];

        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = 0;
        }

        for (int i = 1; i < dp.length - 1; i++) {
            dp[i][i + 1] = arr[i - 1] * arr[i] * arr[i + 1];
        }

        for (int j = 3; j < dp.length; j++) {
            for (int i = j - 2; i >= 1; i--) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
                }
            }
        }


        return dp[1][dp.length - 1];
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 4};
        System.out.println(MatrixChains(ints));

        int[] ints1 = {1, 4, 5, 6, 8};
        System.out.println(MatrixChains(ints1));
    }
}
