package recursion;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }


    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        helper(n, 0, new ArrayList<>(), result);
        return result;
    }

    public static void helper(int n, int row, List<Integer> slate,  List<List<String>> result){

        // backtracking case
        if (canAttack(slate)) {
            return;
        }

        // base case
        if(row == n){
            List<String> strResult = getStringResult(slate, n);
            result.add(strResult);
            return;
        }

        for(int col = 0; col < n; col++){
            slate.add(col);
            helper(n, row+1, slate, result);
            slate.remove(slate.size() - 1);
        }
    }

    public static boolean canAttack(List<Integer> slate){

        if (slate.size() < 2)
            return false;

        int lastRowIdx = slate.size()-1;

        for (int rowIdx=0; rowIdx < lastRowIdx; rowIdx++) {

            if (slate.get(rowIdx) == slate.get(lastRowIdx)) // if placed in same column
                return true;

            if (Math.abs((slate.get(rowIdx) - slate.get(lastRowIdx)))
                    == Math.abs((lastRowIdx - rowIdx))) // they are on the diagonal
                return true;
        }
        return false;
    }

    public static List<String> getStringResult(List<Integer> slate, int n) {

        List<String> result = new ArrayList<>();

        for(Integer queenColPosition : slate) {
            StringBuilder sb = new StringBuilder();
            for(int col=0; col< n; col++){
                if(queenColPosition != col){
                    sb.append(".");
                    continue;
                }
                sb.append("Q");
            }
            result.add(sb.toString());
        }
        return result;
    }
}

