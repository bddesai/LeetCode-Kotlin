package recursion;

import java.util.ArrayList;
import java.util.List;

public class NchooseK {

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        List<List<Integer>> answer = find_combinations(n, k);
        System.out.println(answer);
        System.out.println(String.format("Number of Combinations = %d", answer.size()));
    }

    public static List<List<Integer>> find_combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    static void helper(int n, int k, int index, List<Integer> slate, List<List<Integer>> result) {

        // base case
        if (k == slate.size()) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // solution
        for (int i = index; i < n; i++) {
            //include
            slate.add(i);
            helper(n, k, index + 1, slate, result);

            //exclude
            slate.remove(slate.size() - 1);
        }

    }
}
