import java.util.ArrayList;
import java.util.List;

public class CountUniquePaths {


    public static void main(String[] args) {
//        1 1 1 1
//        1 1 1 1
//        1 1 1 1

        List<List<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<Integer>() {{ add(1);add(1);add(0);add(1); }});
        matrix.add(new ArrayList<Integer>() {{ add(1);add(1);add(1);add(1); }});
        matrix.add(new ArrayList<Integer>() {{ add(1);add(1);add(1);add(1); }});
        matrix.add(new ArrayList<Integer>() {{ add(1);add(1);add(1);add(1); }});

        System.out.println("Number of paths = " + numberOfPathsss(matrix));

    }

    public static int numberOfPaths(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

//        if (matrix.get(m - 1).get(n - 1) == 0)
//            return 0;

        int[][] table = new int[m][n];

        for (int i = 0; i < m; i ++){
            table[i][0] = 1;
        }
        for (int j = 0; j < n; j ++){
            table[0][j] = 1;
        }

        for (int row = 1; row < m; row++){
            for (int col = 1; col < m; col++){
                table[row][col] = table[row -1 ][col] + table[row][col-1];
            }
        }

        return table[m-1][n-1];
    }

    public static int numberOfPathsss(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        if (matrix.get(m - 1).get(n - 1) == 0)
            return 0;


        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;


        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix.get(i).get(j) == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i < m - 1) {
                    dp[i][j] = dp[i + 1][j];
                }

                if (j < n - 1) {
                    dp[i][j] = dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
