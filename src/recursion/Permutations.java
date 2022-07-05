import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        helper(numsList, 0, result);

        return result;
    }

    private static List<List<Integer>> helper(ArrayList<Integer> nums,
                                             int index,
                                             List<List<Integer>> result) {

        if (index == nums.size()) {
            result.add(new ArrayList<>(nums));
            return result;
        }

        for (int j = index; j < nums.size(); j++) {
            Collections.swap(nums, index, j);
            helper(nums, index + 1, result);
            Collections.swap(nums, index, j);
        }

        return result;
    }


}
