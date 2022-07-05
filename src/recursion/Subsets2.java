import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{2, 2, 1}));
    }

    static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();

        subsetHelper(result, slate, nums, 0);

        return result;
    }

    static void subsetHelper(List<List<Integer>> result,
                             List<Integer> slate,
                             int[] nums, int index) {

        result.add(new ArrayList<>(slate));

        for (int i=index; i < nums.length; i++) {
            if (index != i && nums[i] == nums[i - 1]) {
                continue;
            }

            slate.add(nums[i]);
            subsetHelper(result, slate, nums, i + 1);
            slate.remove(slate.size() - 1);
        }

    }
}
