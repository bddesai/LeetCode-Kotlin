import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PermuteArrayDuplicates {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);

        System.out.println(get_permutations(arr));
    }


    static List<List<Integer>> get_permutations(List<Integer> arr) {
        List<List<Integer>> result = new LinkedList<>();
        Collections.sort(arr);
        solve(arr, 0, result);
        return result;
    }

    static void solve(List<Integer> arr, int start, List<List<Integer>> result) {
        if (start == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            int current = arr.get(i);
            if (i > start && current == arr.get(i - 1) ) continue;
            if (i != start && current == arr.get(start)) continue;
            Collections.swap(arr, start, i);
            solve(arr, start + 1, result);
            Collections.swap(arr, start, i);
        }
    }

}
