import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuteArrayUniqueIntegers {


    public static void main(String[] args) {
        List<List<Integer>> plist = get_permutations(Arrays.asList(1, 2, 3));
        System.out.println(Arrays.toString(plist.toArray()));
    }

    static List<List<Integer>> get_permutations(List<Integer> arr) {

        List<List<Integer>> parentList = new ArrayList<>();
        permutations_helper(arr, parentList, 0);

        return parentList;
    }

    static void permutations_helper(
            List<Integer> arr,
            List<List<Integer>> parentList,
            int k) {

        if (k == arr.size()-1) {
            parentList.add(new ArrayList<>(arr));
            return;
            //System.out.println(java.util.Arrays.toString(arr.toArray()));
        }

        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permutations_helper(arr, parentList, k + 1);
            Collections.swap(arr, k, i);
        }
    }
}
