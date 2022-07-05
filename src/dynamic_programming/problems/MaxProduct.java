package Dynamic_Programming;

public class MaxProduct {

    /* Driver program to test above functions */
    public static void main(String[] args) {
        System.out.println("Maximum Product is "
                + maxProd(5));
    }

//    static long maxProd_2(int n) {
//        // Base cases
//        if (n == 0 || n == 1) return 0;
//
//        // Make a cut at different places
//        // and take the maximum of all
//        int max_val = 0;
//        for (int i = 1; i < n; i++)
//            max_val = (int) Math.max(max_val,
//                    Math.max(i * (n - i), maxProd_2(n - i) * i));
//
//        // Return the maximum of all values
//        return max_val;
//    }


    static int maxProd(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];

        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j <= (i / 2); j++) {
                //System.out.println(String.format("i = %s, j = %s", i, j));
                dp[i] = Math.max(
                        dp[i],
                        Math.max(j * (i - j),
                                j * dp[i - j]
                        ));
            }
        }

        return dp[n];
    }


}
