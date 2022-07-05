package misc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveUniques {

    public static void main(String[] args) {
        Integer[] nums1 = {1, 2, 2, 3, 4, 5};
        Integer[] nums2 = {2, 4, 5, 5, 5, 6};

        //removeDuplicates(nums1);
        removeUnique(nums1, nums2);
    }


    public static void removeUnique(Integer[] nums1, Integer[] nums2) {
        ///Arrays.sort(nums1);
        Integer[]c = new Integer[nums1.length+nums2.length];
        int count = 0;

        for(int i = 0; i < nums1.length; i++) {
            c[i] = nums1[i];
            count++;
        }
        for(int j = 0; j < nums2.length;j++) {
            c[count++] = nums2[j];
        }

        removeDuplicates(c);


    }

    public static void removeDuplicates(Integer[] nums) {

        List<Integer> listWithDuplicates = Arrays.asList(nums);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(Arrays.toString(listWithoutDuplicates.toArray()));
    }
}
